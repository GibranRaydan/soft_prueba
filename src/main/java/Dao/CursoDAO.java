/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Curso;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import util.DbUtil;

/**
 *
 * @author anfeg
 */
public class CursoDAO {
     private Connection connection;

    public CursoDAO() throws SQLException, URISyntaxException {
        connection = DbUtil.getConnection();
    }
    

}
