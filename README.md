# Glossary of Terms
Программа по типу приложения для смартфонов "Слово дня".</br>
Только позволяет самостоятельно составлять свою базу слов, а также удалять уже выученные слова.</br>
Слова сменяются по таймеру.
```
NeoTimer.getInstance().schedule(new TimerTask() {
                                            public void run() {
                                                getTermRandom();
                                            }
                                        },
                0, 40000);
```

Слова из базы данных выбираются в случайном порядке (10 штук) в массив после того, как все они по очереди будут выведены на экран, операция повторяется. </br>

Внешне программа вылядит довольно просто:</br>

![alt text](https://github.com/Liliannna/Glossary-of-Terms/blob/master/screenshot/Glossary_of_Terms_HRq1k7UXGa.png)

При нажатии на кнопку "Добавить" открывается новое окно: </br>

![alt text](https://github.com/Liliannna/Glossary-of-Terms/blob/master/screenshot/ASo5ie7XJ7.png)

А при нажатии на кнопку "Удалить" появляется окно для подтверждения удаления:</br>

![alt text](https://github.com/Liliannna/Glossary-of-Terms/blob/master/screenshot/Glossary_of_Terms_jaB4JhSQQO.png)


Для создания использовала:
+ JavaFx
+ SQLite
+ Scene Builder


Программу делала для себя и постоянно ее использую.
