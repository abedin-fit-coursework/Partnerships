\# Partnerships



Console application for managing business partnerships between companies, built for the Data Structures and Algorithms course at FIT, Mediterranean University.



Companies and their partnerships are modeled as an undirected weighted graph: each company is a node, each partnership is an edge, and the edge weight is the number of joint projects. Partnerships are stored as adjacency lists.



\## Features



\- Add, edit and delete companies (name, industry, year founded)

\- Add, edit and delete partnerships between companies

\- Count a company's partners from a selected industry and their total number of joint projects

\- List all partnerships with more than N joint projects, marking whether the partners are in the same industry

\- Input validation for all user entries



\## Structure



\- `Company` – node: company data and its list of partnerships

\- `PartnershipEdge` – edge: the partner and the number of joint projects

\- `PartnershipsGraph` – the graph and its operations

\- `Main` – console menu and input validation



\## Running



Requires Java 8 or newer.



```

cd Partnerships/src

javac \*.java

java Main

```



The user interface is in Montenegrin.

