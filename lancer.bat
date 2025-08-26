@echo off
TITLE Lanceur Risk

echo Lancement de l'application Java via PowerShell...

powershell -Command "$Host.UI.RawUI.BufferSize = New-Object System.Management.Automation.Host.Size(120,300); $Host.UI.RawUI.WindowSize = New-Object System.Management.Automation.Host.Size(120,40); Start-Process -FilePath \"$env:JAVA_HOME\bin\java.exe\" -ArgumentList '-XX:+ShowCodeDetailsInExceptionMessages -cp \"%~dp0target\classes\" pf.yozzman.risk.Jeu' -NoNewWindow -Wait"

echo.
echo Le jeu est termine. Appuyez sur une touche pour fermer.
pause
