import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.*;
import java.util.*;

public class VocabAppFX extends Application {

    private HashMap<String, String[]> vocabList = new HashMap<>(); // 単語と発音、和訳を格納
    private Label wordLabel;
    private RadioButton[] optionButtons;
    private ToggleGroup group;
    private String correctAnswer;
    private int currentWordIndex = 0;

    private List<String> wordList = new ArrayList<>();  // 単語リスト

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // ウィンドウタイトル設定
        primaryStage.setTitle("プログラミング英単語学習アプリ");

        // 単語表示ラベル
        wordLabel = new Label("ここに単語が表示されます");

        // 4択ボタン設定
        optionButtons = new RadioButton[4];
        group = new ToggleGroup();
        for (int i = 0; i < 4; i++) {
            optionButtons[i] = new RadioButton();
            optionButtons[i].setToggleGroup(group);
        }

        // 次へボタン
        Button nextButton = new Button("次へ");
        nextButton.setOnAction(e -> checkAnswer());

        // レイアウト
        VBox layout = new VBox(10);
        layout.getChildren().add(wordLabel);
        layout.getChildren().addAll(optionButtons);
        layout.getChildren().add(nextButton);

        // シーン設定
        Scene scene = new Scene(layout, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();

        // CSVから単語を読み込み
        loadVocabFromCSV("words.csv");

        // 最初の単語を表示
        showNextWord();
    }

    // CSVファイルから単語を読み込むメソッド
    private void loadVocabFromCSV(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 3) { // word, pronunciation, meaning
                    vocabList.put(data[0], new String[]{data[1], data[2]});
                    wordList.add(data[0]);
                }
            }
            Collections.shuffle(wordList); // 単語リストをランダムにシャッフル
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 次の単語を表示するメソッド
    private void showNextWord() {
        if (currentWordIndex >= wordList.size()) {
            currentWordIndex = 0;  // リストの最後に達したら最初に戻る
        }

        String word = wordList.get(currentWordIndex);
        String[] wordData = vocabList.get(word);

        // 単語と発音を表示
        wordLabel.setText(word + " " + wordData[0]);

        // 4択の選択肢を表示
        List<String> meanings = new ArrayList<>(vocabList.values().stream().map(data -> data[1]).toList());
        Collections.shuffle(meanings);
        correctAnswer = wordData[1];

        int correctOption = new Random().nextInt(4);  // 正解の位置をランダムに決定
        optionButtons[correctOption].setText(correctAnswer);

        for (int i = 0; i < 4; i++) {
            if (i != correctOption) {
                optionButtons[i].setText(meanings.get(i));
            }
        }

        currentWordIndex++;
    }

    // 解答をチェックして次に進むメソッド
    private void checkAnswer() {
        RadioButton selectedButton = (RadioButton) group.getSelectedToggle();

        if (selectedButton != null) {
            String selectedAnswer = selectedButton.getText();
            if (selectedAnswer.equals(correctAnswer)) {
                // 正解
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("正解");
                alert.setHeaderText(null);
                alert.setContentText("正解です！");
                alert.showAndWait();
            } else {
                // 不正解
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("不正解");
                alert.setHeaderText(null);
                alert.setContentText("不正解です。正解は: " + correctAnswer);
                alert.showAndWait();
            }
            showNextWord();
        } else {
            // 選択肢が選ばれていない場合
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("エラー");
            alert.setHeaderText(null);
            alert.setContentText("選択肢を選んでください！");
            alert.showAndWait();
        }
    }
}
