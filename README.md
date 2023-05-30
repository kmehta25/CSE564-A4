# Travelling Salesman Problem Solver

This project is a Java application developed to solve the Travelling Salesman Problem (TSP) using various algorithms and Design Patterns. The application utilizes Java Swing for the graphical user interface (GUI) and incorporates essential software engineering principles to create an efficient and user-friendly solution.

## Table of Contents

- [Description](#description)
- [Features](#features)
- [Installation](#installation)
- [Usage](#usage)
- [Technologies](#technologies)
- [Contributing](#contributing)
- [License](#license)

## Description

The Travelling Salesman Problem is a well-known optimization problem in computer science where the task is to find the shortest possible route that visits all given cities and returns to the starting city. This project focuses on implementing different algorithms and design patterns to solve the TSP efficiently.

The application provides a GUI that allows users to interact with the workspace by creating cities, connecting them using various algorithms (including TSP Nearest Neighbor, TSP Pro, Clusters, and User Connect), and customizing city attributes such as shape, color, and size. Users can also save and load city configurations using a file picker.

## Features

- Creation of cities by clicking on the workspace
- Implementation of TSP algorithms: Nearest Neighbor and TSP Pro
- Clustering of cities using K-means algorithm to create cyclical paths
- User-defined connections by manually selecting cities
- Interactive GUI with options for creating, connecting, and moving cities
- Ability to edit city attributes such as shape, color, and size using the Decorator pattern
- File menu options for creating, saving, and loading city configurations
- Real-time logging mechanism to provide feedback and updates to the user

## Installation

1. Clone the repository: `git clone https://github.com/kmehta25/CSE564-A4.git`
2. Ensure you have Java Development Kit (JDK) installed.
3. Compile the Java source files: `javac Main.java`
4. Run the application: `java Main`

## Usage

1. Launch the application.
2. Click on the workspace to create cities.
3. Choose the desired algorithm from the "Connections" menu or manually connect cities using the "User Connect" option.
4. Use the "Action" menu to select the desired mode: Move, Connect, or Create.
5. Double-click on a city to edit its attributes.
6. Utilize the file menu options to save and load city configurations.
7. Monitor the logger at the bottom of the GUI for updates and messages.

## Technologies

- Java
- Java Swing (GUI)
- Design Patterns: Abstract Factory, Decorator, Chain of Responsibility, Observer
