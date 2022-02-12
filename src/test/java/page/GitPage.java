package page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class GitPage {
    final private static String search = " //input[@name=\"q\"]";
    final private static String articles = "//a[@class=\"v-align-middle\"]";
    final private static String fav = "//button[@class=\"js-toggler-target rounded-left-2 btn-sm btn BtnGroup-item\"]";
    final private static String favActiveButtonsInMyFav = "//div[@class=\"js-social-container js-form-toggle-container d-flex BtnGroup float-right js-toggler-container starring-container on\"]";
    final private static String profile = "//img[@class=\"avatar avatar-small circle\"]";
    final private static String myFav = "//a[text()=\"Your stars\"]";
    final private static String articlesInFav = "//div[@class=\"d-inline-block mb-1\"]";
    final private static String logo = "//a[@class=\"Header-link \"]";


    ElementsCollection articlesMass = $$x(articles);
    ElementsCollection articlesInFavMass = $$x(articlesInFav);
    ElementsCollection firstLogo = $$x(logo);
    ElementsCollection favActiveButtonInMyFav = $$x(favActiveButtonsInMyFav);


    @Step("Шаг 0. Проверка, что нет добавленых статей. Есть есть - удаляем. Ну, пусть примерно у нас не должно быть больше 10 статей")
    public void checkArticlesSize() {
        $x(profile).click();
        $x(myFav).click();
        for (int i=0; i<10; i++) {
            if (articlesInFavMass.get(i).isDisplayed()) {
                favActiveButtonInMyFav.get(i).click();
            }
        }
        firstLogo.get(0).click();
    }


    @Step("Ввод слова и поиск")
    public void searchWord() {
        $x(search).setValue("ktor").pressEnter();
    }

    @Step("Кликаем на первую статью")
    public void clickArticle() {
        articlesMass.get(0).shouldBe(Condition.visible);
        articlesMass.get(0).click();
    }

    @Step("Добавляем в фав")
    public void pressFav() {
        $x(fav).shouldBe(Condition.visible);
        $x(fav).click();
    }

    @Step("Нажимаем на \"Избранное\"")
    public void pressMyFav() {
        $x(profile).click();
        $x(myFav).click();
    }

    @Step("Проверяем, что статья добавлена. То есть в пустой директории появился 1 объект с помощью нашего добавления")
    public void checkItsOnlyOneFav() {
        articlesInFavMass.shouldHave(size(1));
    }
}
