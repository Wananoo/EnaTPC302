@SET HH=%time:~-11,2%
@SET MM=%time:~-8,2%
@SET /p MENSAJE=Mensaje: 
@SET "HORA=%HH%h%MM%m"
@SET "FECHAHORA=%DATE%%HORA%"
@SET "MSG=%FECHAHORA% %MENSAJE%"

git add .

git commit -m" %MSG% "

git push origin master

@PAUSE