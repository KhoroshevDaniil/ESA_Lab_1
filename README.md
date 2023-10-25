# ESA_Lab_1

Приложение реализовано с использованием JakartaEE 9.1 и было протестировано на сервере приложений TomEE 9.0

Также была использована база данных PostgreSQL. Для корректной работы приложения переопределите подключение к БД в файле [persistence.xml](https://github.com/KhoroshevDaniil/ESA_Lab_1/blob/master/src/main/resources/META-INF/persistence.xml#L15)

В качестве предметной области была выбрана **научная конференция**, включающая в себя 2 объекта: участник (Participant) и научная статья (Paper)


## Data Layer ##
В модуле [com.example.model](https://github.com/KhoroshevDaniil/ESA_Lab_1/tree/master/src/main/java/com/example/model) реализовано два Java Beans: [Participant](https://github.com/KhoroshevDaniil/ESA_Lab_1/blob/master/src/main/java/com/example/model/Participant.java) и [Paper](https://github.com/KhoroshevDaniil/ESA_Lab_1/blob/master/src/main/java/com/example/model/Paper.java).

Сущность **Participant** (table_name = _participats_):
- id: **Long**
- name: **String**
- age: **int**
- academicDegree: **String**

Сущность **Paper** (table_name = _papers_):
- id: **Long**
- title: **String**
- year: **int**
- participant_id: **int** - внешний ключ к таблице _participants_

## Business Layer ##
За бизнес-логику приложения отвечают следующие Session Beans:
- [PaperService](https://github.com/KhoroshevDaniil/ESA_Lab_1/blob/master/src/main/java/com/example/service/PaperService.java)
- [ParticipantService](https://github.com/KhoroshevDaniil/ESA_Lab_1/blob/master/src/main/java/com/example/service/ParticipantService.java)

При добавлении сущности Paper с несуществующим в системе именем автора (Participant) - добавится новый автор с введённым именем.

## View Layer ##
За обработку запросов отвечают следующие сервлеты:
- [PaperServlet](https://github.com/KhoroshevDaniil/ESA_Lab_1/blob/master/src/main/java/com/example/servlet/PaperServlet.java) - обрабатывает действия на странице papers.jsp
- [ParticipantServlet](https://github.com/KhoroshevDaniil/ESA_Lab_1/blob/master/src/main/java/com/example/servlet/ParticipantServlet.java) - обрабатывает действия на странице participants.jsp

UI реализован в следующих jsp страницах:
- [index.jsp](https://github.com/KhoroshevDaniil/ESA_Lab_1/blob/master/src/main/webapp/index.jsp)
- [papers.jsp](https://github.com/KhoroshevDaniil/ESA_Lab_1/blob/master/src/main/webapp/papers.jsp)
- [participants.jsp](https://github.com/KhoroshevDaniil/ESA_Lab_1/blob/master/src/main/webapp/participants.jsp)

