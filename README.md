# notes-with-spring
Заметки с Spring Core
Приложение создано для выполнения тестового задания.

Так же создал аналогичное веб приложение с применением Spring Boot https://github.com/Elrik379/notes-with-SpringBoot

Написано на Java 16 и Spring Context 5.3.25. При возникновении проблемы со шрифтом перезапустить со сменой кодировки на UTF-8 либо windows-1251

Приложение написано в консольном варианте с использованием контекста Spring и сериализации и десериализации сохраненных данных из JSON. 
Функционал приложения состоит из:
- Добавление заметки
- Просмотр всех заметок
- Удаление заметки по ее названию
- Редактирование заметки
- Подсчет общего количества существующих заметок
- При завершении работы приложение сохраняет все данные в JSON формате, а при запуске загружает их.

В дальнейшем приложение можно улучшить добавлением графического интерфейса и сохранением данных не в файл, а в базы данных

![image](https://user-images.githubusercontent.com/92898813/222927080-8390b35a-2f2b-4947-b78b-457b20e2fa55.png)
