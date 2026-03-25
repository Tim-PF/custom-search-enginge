# custom-search-enginge
I got curious on how to build a search engine. So lets do it!

# Disclaimer
This Readme is used by me to articulate my thoughts during developement to make it clear to me if I truly understood the problems I want to solve.

# Step 1 – Reading Files

To approach the problem, I decided to break it down into smaller, manageable steps.
The first problem I identified was reading files from a directory.
To reduce complexity, I limited the scope to text files only.
For implementation, I explored the standard Java/Kotlin file system APIs and chose the `File` class from `java.io`, since it provides the necessary functionality without requiring external libraries.
This step establishes the foundation for further processing like tokenization and indexing.

# Step 2 - Tokenization

The next step is to transform text into tokens. Tokens represent the individual words contained in the text of my data files.
I considered different data structures to store these tokens. After some thought, I decided to use a List.
A List allows me to:
- preserve the original order of words
- keep duplicates
Keeping duplicates might be important later, for example when implementing ranking based on word frequency.
A Set, on the other hand, would remove duplicates and therefore lose important information.


# Step 3 – Indexing

In this step, I implemented a basic indexing mechanism for the search engine.

The goal is to process all available text files and create a structure that allows fast lookup of tokens across documents.

## Current Approach

I used two maps:

- One map assigns each text file a unique integer ID  
- Another map links each token to the IDs of the files in which it appears  

This results in a simple inverted index.

## Process

For each file in the `data/` directory:

1. The file is read as text  
2. The content is tokenized into individual words  
3. Each token is added to the index:
   - If the token already exists, the current document ID is added  
   - If not, a new entry is created with the document ID  

## Result

The index structure maps tokens to the set of document IDs where they occur.

### Example

"kotlin" -> [0, 2]
"java" -> [1]

This allows efficient lookup of which documents contain a given word.

## Notes
- Currently, only `.txt` files are supported  
- The indexing logic is implemented directly and will be refactored into a dedicated function in the next step  
- The focus of this step was correctness and functionality, not code structure  
