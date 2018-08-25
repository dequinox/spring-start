# Java Spring Assignment

A simple project that parses 3 files parallel and returns matched keys.

## Getting Started

```
http://localhost:8080/find
```

and respond that returns ArrayList<String> of key values.
You can customize the search with optional name, first, second parameters in the query string.

```
http://localhost:8080/find?name=tmp&second=1.1&first=5
```
Files that will be parsed should contain simple name-value pairs, separated by an '=' sign. 
Examples of valid input: 

```
height21.2 = 167cm
mass35.1 =  65kg
disposition12.5 =  "grumpy"
this is the name1.3 = this is the value
```
