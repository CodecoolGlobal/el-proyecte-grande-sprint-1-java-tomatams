<!-- Improved compatibility of back to top link: See: https://github.com/othneildrew/Best-README-Template/pull/73 -->
<a name="readme-top"></a>

<!-- PROJECT SHIELDS -->
<!--
*** I'm using markdown "reference style" links for readability.
*** Reference links are enclosed in brackets [ ] instead of parentheses ( ).
*** See the bottom of this document for the declaration of the reference variables
*** for contributors-url, forks-url, etc. This is an optional, concise syntax you may use.
*** https://www.markdownguide.org/basic-syntax/#reference-style-links
-->
[![Contributors][contributors-shield]][contributors-url]
[![Forks][forks-shield]][forks-url]
[![Stargazers][stars-shield]][stars-url]
[![Issues][issues-shield]][issues-url]


<!-- PROJECT LOGO -->
<br />
<div align="center">
  <a href="https://github.com/CodecoolGlobal/el-proyecte-grande-sprint-1-java-tomatams">
    <img src="frontend/src/images/Logo.png" alt="Logo" width="220" height="180">
  </a>

<h3 align="center">:blueberries: Tantalizing Treats :kiwi_fruit:</h3>

  <p align="center">
    Our Team created a recipe sharing site where you can share your recipes, like Street Kitchen https://streetkitchen.hu. We wanted to make a webpage which has a nice UI and easy to use without ads. It's about practicing Java Spring and React.
    <br />
    <a href="https://github.com/CodecoolGlobal/el-proyecte-grande-sprint-1-java-tomatams"><strong>Explore the docs :arrow_right:</strong></a>
    <br />
    <br />
    ·
    <a href="https://github.com/CodecoolGlobal/el-proyecte-grande-sprint-1-java-tomatams/issues">Report Bug :lady_beetle:</a>
    ·
    <a href="https://github.com/CodecoolGlobal/el-proyecte-grande-sprint-1-java-tomatams/issues">Request Feature :memo:</a>
  </p>
</div>

1. week project demo: <a href="https://docs.google.com/presentation/d/19x2YyDQeWyK21higDhK7i5lahrSMuKDAOC6bCFbdCSk/edit?usp=sharing">View Demo :computer:</a>
2. week project demo: <a href="https://docs.google.com/presentation/d/1X9CGGA9D7I62SVOtY8P8FMMwabrNqM3qqyMS1oeyk_A/edit?usp=sharing">View Demo :computer:</a>
3. week project demo: <a href="https://docs.google.com/presentation/d/1sGaNMuaBGTALJOXPdZwR2xtyUVuCvesVq86oAZNIgdA/edit?usp=sharing">View Demo :computer:</a>
4. week project demo: <a href="https://docs.google.com/presentation/d/1KSAMPQHO-BbCdZFLKzleiZd_f-0By3VmAB_Xgd5-VPE/edit?usp=sharing">View Demo :computer:</a>
   <br />
   <br />

<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#built-with">Built With</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#prerequisites">Prerequisites</a></li>
        <li><a href="#installation">Installation</a></li>
      </ul>
    </li>
    <li><a href="#usage">Usage</a></li>
    <li><a href="#contributing">Contributing</a>
    <li><a href="#contact">Contact</a></li>
    <li><a href="#acknowledgments">Acknowledgments</a></li>
  </ol>
</details>



<!-- ABOUT THE PROJECT -->
## About The Project

The project is about creating a recipe sharing site. As a guest you can look at recipes which was made by other users. After registration, you can add your own recipes.
You can search for a specific recipe or ingredients.

<p align="right">(<a href="#readme-top">:top:</a>)</p>


### Built With

* [![React][React.js]][React-url]
* [![Spring][Spring.img]][Spring-url]
* [![SpringBoot][SpringBoot.img]][SpringBoot-url]
* [![Postgres][Postgres.img]][Postgres-url]

<p align="right">(<a href="#readme-top">:top:</a>)</p>



<!-- GETTING STARTED -->
## Getting Started

Please see the core dependencies and installation steps below:

### Prerequisites
1. JAVA 17
2. MAVEN
3. POSTGRES SQL
4. IDE - for backend, for example INTELLIJ IDEA
6. Docker(Optional)

### Installation
1. Clone the repo
   ```sh
   git clone git@github.com:CodecoolGlobal/el-proyecte-grande-sprint-1-java-tomatams.git
   ```
#### In PostgreSQL
2. Create a database in PostgreSQL named :
      ```sh
   springrolls
   ```
#### In IDE
3. Open the project in IDE from the pom.xml file :open_file_folder:
4. in backend/src/main/resources/application.properties file set the database name, username and password as environment variables as follows: <br>
   :white_check_mark: DATABASE_NAME=_springrolls_<br>
   :white_check_mark: DATABASE_USERNAME=_your username_<br>
   :white_check_mark: DATABASE_PASSWORD=_your password_<br>
   
##### Backend Side
5. Run the application by the "Run" button in the top right corner or with Shift + F10 shortcut in INTELLIJ IDEA, or You can run a Spring Boot application from your IDE as a simple Java application (ElProyecteGrandeSprint1JavaTomatamsApplication.java),
6. This will start the project backend side,


#### In Terminal
##### Frontend Side
7.	Move into the project’s folder /frontend/,
8.	Run the following command in the terminal :
   ```sh
   npm start
   ```
9.	This will start the project frontend side, and you can reach in your browser, on the following URL: _http://localhost:3000/_

#### Dockerization (Optional)
10. Shut down the backend and fronted side, if you started,
11. Open a terminal and navigate to the directory – project directory - /backend/ - containing the Docker compose file. 
12. Run the following command in the terminal :
   ```sh
   docker-compose up
   ```
13. After compose, you can reach the side on _http://localhost:8080/_

    
<p align="right">(<a href="#readme-top">:top:</a>)</p>



<!-- USAGE EXAMPLES -->
## Usage

In this project, you can _browse in recipes_ and view them in details. There are some _filtering_ options for
the recipes, as well as a _search bar_ to find recipes by name. You can _create profile_ for yourself and _log in_
to create your own recipes. As an admin you can delete the recipes.

<p align="right">(<a href="#readme-top">:top:</a>)</p>


<!-- CONTRIBUTING -->
## Contributing
This project was made by four Codecool students: Anna Cseke, Gergely Cselőtei, Péter Jung, Tamás Toma.

<!-- CONTACT -->
## Contact

:woman_technologist: Anna Cseke - :email: anna.cseke[at]gmail[dot]com [![LinkedIn][linkedin-shield]][linkedin-Anna]<br>
:man_technologist: Gergely Cselőtei - :email: cseloteigergely[at]gmail[dot]com [![LinkedIn][linkedin-shield]][linkedin-Gergely]<br>
:man_technologist: Péter Jung - :email: jung.peter24[at]gmail[dot]com [![LinkedIn][linkedin-shield]][linkedin-Peter]<br>
:man_technologist: Tamás Toma - :email: tomatams[at]gmail[dot]com [![LinkedIn][linkedin-shield]][linkedin-Tamás]<br>

Project Link: [https://github.com/CodecoolGlobal/el-proyecte-grande-sprint-1-java-tomatams](https://github.com/CodecoolGlobal/el-proyecte-grande-sprint-1-java-tomatams)

<p align="right">(<a href="#readme-top">:top:</a>)</p>



<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->
[contributors-shield]: https://img.shields.io/github/contributors/CodecoolGlobal/el-proyecte-grande-sprint-1-java-tomatams?style=for-the-badge
[contributors-url]: https://github.com/CodecoolGlobal/el-proyecte-grande-sprint-1-java-tomatams/graphs/contributors
[forks-shield]: https://img.shields.io/github/forks/CodecoolGlobal/el-proyecte-grande-sprint-1-java-tomatams?style=for-the-badge
[forks-url]: https://github.com/CodecoolGlobal/el-proyecte-grande-sprint-1-java-tomatams/forks
[stars-shield]: https://img.shields.io/github/stars/CodecoolGlobal/el-proyecte-grande-sprint-1-java-tomatams?style=for-the-badge
[stars-url]: https://github.com/CodecoolGlobal/el-proyecte-grande-sprint-1-java-tomatams/stargazers
[issues-shield]: https://img.shields.io/github/issues/CodecoolGlobal/el-proyecte-grande-sprint-1-java-tomatams?style=for-the-badge
[issues-url]: https://github.com/CodecoolGlobal/el-proyecte-grande-sprint-1-java-tomatams/issues

[license-shield]: https://img.shields.io/github/license/placi0325/Stackoverflow-TW5.svg?style=for-the-badge
[license-url]: https://github.com/github_username/repo_name/blob/master/LICENSE.txt
[linkedin-shield]: https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white
[linkedin-Peter]: https://www.linkedin.com/in/pjung-dev
[linkedin-Anna]: https://www.linkedin.com/in/anna-cseke-847b1963/
[linkedin-Tamás]: https://www.linkedin.com/in/tomatams/
[linkedin-Gergely]: https://www.linkedin.com/in/gergely-csel%C5%91tei-4469a127a/
[product-screenshot]: images/screenshot.png
[React.js]: https://img.shields.io/badge/React-20232A?style=for-the-badge&logo=react&logoColor=61DAFB
[React-url]: https://reactjs.org/
[JavaScript.img]:     https://img.shields.io/badge/JavaScript-323330?style=for-the-badge&logo=javascript&logoColor=F7DF1E
[JavaScript-url]: https://www.javascript.com/
[Spring.img]: https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white
[Spring-url]: https://spring.io/
[Postgres.img]: https://img.shields.io/badge/PostgreSQL-316192?style=for-the-badge&logo=postgresql&logoColor=white
[Postgres-url]: https://www.postgresql.org/
[SpringBoot.img]: https://img.shields.io/badge/Spring_Boot-F2F4F9?style=for-the-badge&logo=spring-boot
[SpringBoot-url]: https://spring.io/projects/spring-boot
[Docker.img]: https://img.shields.io/badge/Docker-2CA5E0?style=for-the-badge&logo=docker&logoColor=white
[Docker-url]: https://www.docker.com/
