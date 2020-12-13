package article;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DAO.*;

public class GetArticles {
	
	articleDAO article;
	
	GetArticles (){
		article = new articleDAO();
	}
public List<Article> getProduitsParMotCle(int code , String nom) throws SQLException, ClassNotFoundException { 
		
		List<Article> articles= new ArrayList<Article>();
		ResultSet rs = this.article.rechercheArticle(code, nom);

	while (rs.next()) {
	Article a = new Article(); 
	a.setCode(rs.getInt("code")); 
	a.setName(rs.getString("name")); 
	a.setPrice(rs.getDouble("price"));
	a.setDescription(rs.getString("description"));
	a.setQte((int)(rs.getDouble("qte")));
	articles.add(a);
	}
	
	return articles;
	}

	
}
