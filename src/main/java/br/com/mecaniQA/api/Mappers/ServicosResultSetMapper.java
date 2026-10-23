package br.com.mecaniQA.api.Mappers;
import java.sql.*; import br.com.mecaniQA.api.model.*; import br.com.mecaniQA.api.Enums.*;
public class ServicosResultSetMapper implements ResultSetMapper<Servicos>{public Servicos map(ResultSet r)throws SQLException{Servicos x=new Servicos(r.getString("nome_servico"),r.getInt("tempo_estimado_minutos"),r.getDouble("custo_tabelado"));x.setCodUnico(r.getLong("cod_unico"));Timestamp t=r.getTimestamp("data_atualizacao");x.setDataAtualizacao(t==null?null:t.toLocalDateTime());return x;}}
