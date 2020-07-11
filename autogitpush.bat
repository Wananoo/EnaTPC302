@setlocal EnableDelayedExpansion
@SET HH=%time:~-11,2%
@SET MM=%time:~-8,2%
@SET /p MENSAJE=Mensaje: 
@SET MSG=!%DATE% %HH%:%MM% -- %MENSAJE%!

git add .

git commit -m" %MSG% "

git push origin master

PAUSE