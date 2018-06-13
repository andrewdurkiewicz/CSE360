cd src
javac -classpath . gui/JUML.java -d ../bin/

##Ask user if they want to run the compiled program (assuming it did)
read -p "Attempt to Run? [y/n] " -n 1 -r
echo    # (optional) move to a new line
if [[ $REPLY =~ ^[Yy]$ ]]
then
    cd ../bin
    java gui/JUML
fi