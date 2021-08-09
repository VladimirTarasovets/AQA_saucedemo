#language:ru
#encoding:UTF-8

@newTest
  Функционал: Авторизация на сайте

    Сценарий: Авторизация на сайте "https://www.saucedemo.com/"
      Допустим открыта страница "https://www.saucedemo.com/"
      И в поле ввода логина введено значение "standard_user"
      И в поле ввода пароля введено значение "secret_sauce"
      И нажата кнопка "Login"
      Тогда пользователь авторизован на странице "https://www.saucedemo.com/inventory.html"
