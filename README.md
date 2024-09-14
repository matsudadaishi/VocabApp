
# VocabApp

## 概要
VocabAppは、JavaとJavaFXを使用して開発された英単語学習アプリです。このアプリでは、英単語、発音（カタカナ表記）、和訳がクイズ形式で表示されます。ユーザーはランダムに表示される4つの選択肢の中から、正しい意味を選択します。プログラミングに関連する専門用語を学ぶのに役立ちます。

## 機能
- **ランダムクイズ**: ランダムに英単語が表示され、4択形式で意味を問います。
- **発音表示**: 英単語にはカタカナ表記の発音が表示されます。
- **結果フィードバック**: 正解または不正解の通知が表示されます。

## 必要な環境
- **Java 11以上**
- **JavaFX**ライブラリ

### JavaFXのセットアップ
1. JavaFX SDKを[こちら](https://gluonhq.com/products/javafx/)からダウンロード。
2. ダウンロードしたファイルを解凍し、`lib`フォルダのパスをメモしてください。

## 実行方法

### 1. クローンまたはダウンロード
リポジトリをクローンまたはZIPとしてダウンロードし、解凍します：
```bash
git clone https://github.com/your-username/VocabApp.git
```

### 2. アプリケーションを実行
コマンドラインから以下を実行してアプリを起動します（`path-to-javafx-sdk`にはJavaFXの`lib`フォルダのパスを指定してください）：

```bash
java --module-path "path-to-javafx-sdk/lib" --add-modules javafx.controls,javafx.fxml -jar VocabAppFX.jar
```

例:
```bash
java --module-path "C:/javafx-sdk-22.0.2/lib" --add-modules javafx.controls,javafx.fxml -jar VocabAppFX.jar
```

### 3. バッチスクリプトで実行（Windowsユーザー向け）
`run_vocabapp.vbs`をダブルクリックすると、自動的にアプリが起動します。

## プロジェクト構成
- **VocabAppFX.java**: メインクラス。アプリケーションのロジックを担当。
- **words.csv**: 英単語、発音（カタカナ）、和訳が保存されたファイル。アプリがこのデータを読み込んでクイズを作成します。
- **manifest.txt**: JARファイルの実行に使用されるマニフェストファイル。
- **run_vocabapp.vbs**: Windows用のスクリプトファイル。ダブルクリックでアプリが起動します。

## 使用例
1. アプリを起動すると、英単語がカタカナの発音とともに表示されます。
2. 4つの選択肢の中から正しい意味を選んでください。
3. 正解または不正解がポップアップで通知されます。
4. 「次へ」ボタンをクリックして次の問題に進みます。

## 貢献方法
1. リポジトリをフォークします。
2. 新しいブランチを作成します (`git checkout -b feature/AmazingFeature`)。
3. 変更をコミットします (`git commit -m 'Add some AmazingFeature'`)。
4. ブランチにプッシュします (`git push origin feature/AmazingFeature`)。
5. プルリクエストを作成します。


