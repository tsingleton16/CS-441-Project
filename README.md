# CS-441-Project

Write a program in Clojure that will read a text file containing unsigned
integers. Your program will read in a large collection of integers and put
them into a list. Using code in your program (i.e. NOT calling a library
routine), sort the integers into order, using either the quicksort or
mergesort algorithm. For the first pass, carry this out in a singlethreaded program. Then, using Clojure's parallelism options, repeat the
sort of the original list, using 2, 4, 8, 16, and 32 threads. Repeat all sorts 5
times on the same hardware and report the average times. Do not count
file access time as part of the sorting time. Plot the completion time as a
function of the number of threads, and produce a short (1-2 page)
document summarizing and explaining your results. The summary
document should include charts or graphs as appropriate to summarize
your data and support your findings.
