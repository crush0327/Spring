package DI_06_Spring;

public class MysqlArticleDao implements ArticleDao {

	@Override
	public void insert(Article article) {
		System.out.println("Mysql Insert 구문실행");

	}

	// update, delete, select....
}
