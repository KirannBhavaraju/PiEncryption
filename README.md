# PiEncryption
The file Crux.java
It contains the classes for image creation.
The image manipulation is done in the same file.
The matlab script is also executed from the same file itself.
Compile and run Crux.java
The input message is given in Message.txt file.
After encryption, Midway_Encryption.txt is generated.
After Decrytion the file Final_Message.txt is generated.



Algorithm Process.

Step 0: The irrational part of Pi is calculated upto n digits (~500000).

Step 1: The system's Entropy is calculated and stored.

Step 2: Base Image is created from the said digits of Pi.

Step 3: Base Image is cropped and a new image is created.

Cropping Parameters: The image is cropped using 4 distinct values which define the system`s randomness.

1. Uptime.

2. Thread id.

3. Process id.

4. Rdtsc number.

Theese 4 parameters define the boundary for the crop and the crop is initiated.
The base image is also dependent on the systems display size.

Step 4: The values from the cropped image ar stored for SMN (Secret Message Number).

Step 5: The message is first encrypted with any generic algorithm.

Step 6: The encrypted digest is then encapsulated with a header and trailer using SMN.

Step 7: The reverse is done for Decryption.
