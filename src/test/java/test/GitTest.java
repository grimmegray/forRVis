package test;

import org.junit.jupiter.api.Test;
import page.GitPage;

public class GitTest extends MainTest {

    GitPage gitPage = new GitPage();

    @Test
    public void gitTest() {
        gitPage.checkArticlesSize();
        gitPage.searchWord();
        gitPage.clickArticle();
        gitPage.pressFav();
        gitPage.pressMyFav();
        gitPage.checkItsOnlyOneFav();
    }
}
