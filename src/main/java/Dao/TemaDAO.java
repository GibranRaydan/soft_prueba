/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import Model.Tema;
import util.DbUtil;

/**
 *
 * @author Gibran
 */
public class TemaDAO {

    private Connection connection;

    public TemaDAO() throws SQLException, URISyntaxException {
        connection = DbUtil.getConnection();
    }

 

}
