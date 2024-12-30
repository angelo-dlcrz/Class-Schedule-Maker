# Ateneo Class Schedule Maker

This is a group project for my Special Topics in Languages: Enterprise Systems Programming class where we created a full-stack application which allows Ateneans to plan out their schedule for the upcoming semester.

## How to Setup Your Development Environment

1. [Clone](https://docs.github.com/en/repositories/creating-and-managing-repositories/cloning-a-repository) this repository into your working machine.
2. Make sure that you have [Java](https://www.oracle.com/ph/java/technologies/downloads/) installed in your machine. It is recommended to use Java 11 or older.
3. Make sure that you have [Node.js](https://nodejs.org/en) installed in your machine.
4. Make sure that you have [XAMPP](https://www.apachefriends.org/download.html) installed in your machine.
5. Make sure that you have cURL installed in your machine. If on Windows, use [this](https://curl.se/windows/). If on MacOS/Linux, cURL is installed by default.
6. Open the XAMPP Control Panel and start Apache and MySQL.
7. Run the UserApp, TimeSlotApp, and ClassScheduleMakerSubjectApp from the IDE you use.
8. In your command line, run the command below. This will populate your database with the necessary class schedule information from AISIS (though for now, it's only the Sem 2 of AY 2024-2025). It's finished when it sends back "Successfully scraped AISIS."

```bash
curl --location --request POST 'http://localhost:9998/timeSlot/runScraper' \
--header 'Cookie: Cookie_1=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MywiZXhwIjoxNzEyODUyMTUzLCJpYXQiOjE3MTI4NDg1NTN9.5nSX-Tm-D52P4ppZ6Gy71cfa5kT7-X2lpB3l2Rdso64'
```

9. In your command line, change your working directory to the directory where you cloned this project. Then change subdirectory to `scheduleMaker/`.
10. Run the following commands:

```console
npm install
npm run dev
```

11. Go to `http://localhost:5173/` on your preferred browser.

## How to Use

1. In the Schedule tab, you can see the list of schedules per department.
2. In the Register tab, you can register a profile of yourself.
3. In the Login tab, you can log yourself in using the credentials you entered for the registration. It is necessary to Register and Login before being able to Create and View your Created Schedule.
4. In the Create Schedule tab, you can add a class into your schedule as you like.
5. In the Created Schedule tab, you can see the class schedule that you created. You can also remove a schedule by clicking on it and confirming it's removal with `OK`.


Enjoy!

## Credits

Thanks to my groupmates [Jacob](https://github.com/CornOnTheKob) and [Aster](https://github.com/astermangabat25) for making this with me!