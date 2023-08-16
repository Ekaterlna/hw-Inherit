import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TasksTest {

    @Test
    public void shouldFindTaskByQuery() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Assertions.assertEquals(true, simpleTask.matches("Позвонить родителям"));
        Assertions.assertEquals(true, epic.matches("Яйца"));
        Assertions.assertEquals(true, meeting.matches("Приложение НетоБанка"));
    }

    @Test
    public void shouldNoFindTaskByQuery() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Assertions.assertEquals(false, simpleTask.matches("Позвонить маме"));
        Assertions.assertEquals(false, epic.matches("Сыр"));
        Assertions.assertEquals(false, meeting.matches("Приложение Яндекс"));
    }
}
