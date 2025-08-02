package objects;

public class Question {
  private String question;
  private String[] options;
  private int correctAnswer;

  public Question(String question, String[] options, int correctAnswer) {
    this.question = question;
    this.options = options;
    this.correctAnswer = correctAnswer;
  }

  public String getQuestion() {
    return question;
  }

  public String[] getOptions() {
    return options;
  }

  public int getCorrectAnswer() {
    return correctAnswer;
  }

  public boolean isCorrect(int answer) {
    return answer == correctAnswer;
  }

  public void displayQuestion() {
    System.out.println(question + "\n");

    for (int i = 0; i < options.length; i++) {
      System.out.println((i + 1) + ". " + options[i]);
    }

    System.out.print("\nTu respuesta (1-" + options.length + "): ");
  }
}
