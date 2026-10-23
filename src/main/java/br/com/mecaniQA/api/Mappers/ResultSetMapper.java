package br.com.mecaniQA.api.Mappers;
import java.sql.*; import java.time.*; import br.com.mecaniQA.api.model.*; import br.com.mecaniQA.api.Enums.*;
public interface ResultSetMapper<T> { T map(ResultSet rs) throws SQLException; }
