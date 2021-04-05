# Bookshelf Application

## Phase 1

**Project Inspiration**

Reading plays a big part of personal development, lifelong learning, and becoming a better thinker. 
And if you're anything like me, you have read a lot of books, but have probably forgotten most of the stuff you’ve read 
and haven’t applied it to your life the way that you would have liked. There is a phenomenon in memory research called 
the forgetting curve, which just shows that over time, our memory for everything decays unless we find a way to engage 
with it or consolidate our memory of the thing. A few months ago, I realized that I don't absorb anything I read and 
even forget which books I’ve read, so I've been actively working to engage with the material I'm reading.

**Application Introduction**

The bookshelf application allows people to engage with the reading material beyond just passively reading it. It will
allow users to:
- add books (with its title, author, and genre) to a list of books
- add notes (with a heading and content) to a book

The intended audience includes avid readers and anyone who would like to keep track of their reading.

## User stories:
- As a user, I want to add a book to my bookshelf
- As a user, I want to remove a book to my bookshelf
- As a user, I want to select a book and view the book's author and genre
- As a user, I want to add notes to a selected book
- As a user, I want to remove notes from a selected book
- As a user, I want to see the list of books in my bookshelf
- As a user, I want to see the list of notes in a selected book
- As a user, I want to save my bookshelf to file
- As a user, I want to load my bookshelf from file

##Phase 4

**Task 2**
- Implemented a robust design for the Notes class. 
- Methods that throw StringTooShortException:
    - Notes(String heading, String notes)
	- setHeading(String heading)
	- setNotes(String notes)
- Tested robust design in NotesTest