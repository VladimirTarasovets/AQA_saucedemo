#language:ru
#encoding:UTF-8

@parameterizedTest
  Функционал: Проверка цены товара

    Структура сценария: Проверка цены товара <productName>
      Допустим открыта страница "https://www.saucedemo.com/"
      И в поле ввода логина введено значение "standard_user"
      И в поле ввода пароля введено значение "secret_sauce"
      И нажата кнопка "Login"
      И выполнено нажатие на ссылку "<productName>"
      Тогда цена товара равна "<productPrice>"
      Примеры:
        | productName                       | productPrice |
        | Sauce Labs Backpack               | $29.99       |
        | Sauce Labs Bike Light             | $9.99        |
        | Sauce Labs Bolt T-Shirt           | $15.99       |
        | Sauce Labs Fleece Jacket          | $49.99       |
        | Sauce Labs Onesie                 | $7.99        |
        | Test.allTheThings() T-Shirt (Red) | $15.99       |