package br.com.mecaniQA.api.Repository;

import br.com.mecaniQA.api.exception.ErroPersistenciaException;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.*;

public abstract class JdbcSupport {
    @FunctionalInterface protected interface RowMapper<T> { T map(ResultSet rs) throws SQLException; }
    protected Connection connection() throws SQLException {
        String url = System.getenv().getOrDefault("DB_URL", System.getProperty("DB_URL", "jdbc:mysql://localhost:3306/mecaniqa?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true"));
        String user = System.getenv().getOrDefault("DB_USER", System.getProperty("DB_USER", "root"));
        String pass = System.getenv().getOrDefault("DB_PASSWORD", System.getProperty("DB_PASSWORD", ""));
        return DriverManager.getConnection(url, user, pass);
    }
    protected <T> List<T> query(String sql, RowMapper<T> mapper, Object... args) {
        try (Connection c=connection(); PreparedStatement ps=c.prepareStatement(sql)) {
            bind(ps,args); try(ResultSet rs=ps.executeQuery()) { List<T> out=new ArrayList<>(); while(rs.next()) out.add(mapper.map(rs)); return out; }
        } catch(SQLException e) { throw new ErroPersistenciaException("Falha ao consultar o MySQL: "+e.getMessage(),e); }
    }
    protected int execute(String sql,Object...args) {
        try(Connection c=connection(); PreparedStatement ps=c.prepareStatement(sql)) { bind(ps,args); return ps.executeUpdate(); }
        catch(SQLException e) { throw new ErroPersistenciaException("Falha ao executar SQL no MySQL: "+e.getMessage(),e); }
    }
    protected long insert(String sql,Object...args) {
        try(Connection c=connection(); PreparedStatement ps=c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)) { bind(ps,args); ps.executeUpdate(); try(ResultSet rs=ps.getGeneratedKeys()){ if(rs.next()) return rs.getLong(1); } return 0; }
        catch(SQLException e) { throw new ErroPersistenciaException("Falha ao inserir no MySQL: "+e.getMessage(),e); }
    }
    private void bind(PreparedStatement ps,Object...args) throws SQLException { for(int i=0;i<args.length;i++) ps.setObject(i+1,args[i]); }
    protected static void setId(Object target,String field,long value) { try { Field f=target.getClass().getDeclaredField(field); f.setAccessible(true); f.setLong(target,value); } catch(ReflectiveOperationException e) { throw new IllegalStateException(e); } }
    protected static java.time.LocalDateTime time(ResultSet rs,String col) throws SQLException { Timestamp t=rs.getTimestamp(col); return t==null?null:t.toLocalDateTime(); }
}
