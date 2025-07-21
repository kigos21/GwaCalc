#!/bin/bash

# Create a directory for the compiled classes if it doesn't exist
mkdir -p bin

# Compile the Java source files
echo "Compiling source files..."
javac -d bin -sourcepath src src/com/main/GwaCalc.java

# Copy resource files to the bin directory
echo "Copying resources..."
cp -r src/res bin/

# Run the application
echo "Starting GwaCalc..."
java -cp bin com.main.GwaCalc

echo "Application finished."
