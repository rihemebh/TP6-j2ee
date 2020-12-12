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
	
	
	public List<Article> getProduitsParMotCle(String mc) { 
		
		List<Article> articles= new ArrayList<Article>();
		mc.toUpperCase();
		Connection conn=SingletonConnection.getConnection();
	try {
	PreparedStatement ps= conn.prepareStatement("select * from artcile where UPPER(code) LIKE ? or UPPER(name) LIKE ?");
	ps.setString(1, "%"+mc+"%");
	ps.setString(2, "%"+mc+"%");
	
	ResultSet rs = ps.executeQuery(); 

	while (rs.next()) {
	Article a = new Article(); 
	a.setCode(rs.getInt("code")); 
	a.setName(rs.getString("name")); 
	a.setPrice(rs.getDouble("price"));
	a.setDescription(rs.getString("description"));
	a.setQte((int)(rs.getDouble("qte")));
	articles.add(a);
	}
	} catch (SQLException e) { e.printStackTrace();
	}
	return articles;
	}

}
