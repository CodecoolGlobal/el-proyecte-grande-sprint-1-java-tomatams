REM - WRITE YOUR COMMANDS HERE
START "epg4" docker build -t epg4 -f Dockerfile.dockerfile
PAUSE
TASKKILL /FI "WINDOWTITLE eq epg4"