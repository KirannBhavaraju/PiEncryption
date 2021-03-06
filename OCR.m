warning off 
clc, close all, clear all
imagen=imread('Crop1.jpg');
imshow(imagen);
title('INPUT IMAGE WITH NOISE')
if size(imagen,3)==3 %RGB image
    imagen=rgb2gray(imagen);
end
threshold = graythresh(imagen); %convert to BW/GrayScale
imagen =~im2bw(imagen,threshold);
imagen = bwareaopen(imagen,25); %less than 25 pixels will not be considered.
word=[ ];
re=imagen;
fid = fopen('text.txt','wt');
load templates
global templates
num_letras=size(templates,2);
while 1
    [fl re]=lines(re);
    imgn=fl;    %imshow(fl);%pause(0.5); % use this for displaying the images one by one.    
    [L Ne] = bwlabel(imgn);    
    for n=1:Ne
        [r,c] = find(L==n);
        n1=imgn(min(r):max(r),min(c):max(c));  % Extract letter  
        img_r=imresize(n1,[42 24]);   %imshow(img_r);pause(0.5) %to show one by one.
        letter=read_letter(img_r,num_letras); % Calling fcn to convert image to text
        word=[word letter];
    end
    fprintf(fid,'%s',word);         %Write 'word' in text file (upper) for lower case fprintf(fid,'%s\n',lower(word));
    word=[ ];
    if isempty(re) 
        break
    end    
end
fclose(fid);
%winopen('text.txt')
clear all