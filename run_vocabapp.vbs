Set shell = CreateObject("WScript.Shell")
shell.Run "cmd /c java --module-path ""C:\Users\dmats\javafx-sdk-22.0.2\lib"" --add-modules javafx.controls,javafx.fxml -jar VocabAppFX.jar", 0
Set shell = Nothing
