package DAO;
import java.util.List;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.sql.Connection;
import article.*;
import ConnexionBD.*;

public class articleDAO {
	
	public ResultSet rechercheArticle(int code, String nom) throws ClassNotFoundException, SQLException{ 
		
		
		
		nom.toUpperCase();
		Connection conn=SingletonConnection.getConnection();
		PreparedStatement ps;

		ps= conn.prepareStatement("select * from artcile where code LIKE ? or UPPER(name) LIKE ?");
		ps.setString(1, "%"+code+"%");
		ps.setString(2, "%"+nom+"%");
		
	
	ResultSet rs = ps.executeQuery(); 
	return rs;
}
	
	

}
