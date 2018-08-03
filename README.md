# Deployment Instructions

### Windows
* Install Chocolatey
* Run `choco install maven`
* Run `choco install mysql`
* Run `choco install nodejs.install`
* Open a new command prompt with admin privileges
* Run `npm install --global gulp-cli`
* Change directories to the root API folder, with pom.xml within, and run mvn install embedded-glassfish:run
* In another terminal window, change directories to the root db directory, where NDNUAlumni.sql resides
* Run `mysql -u root < NDNUAlumni.sql`
* In another terminal window, change directories to the root site directory, where the gulpfile.js file resides
* Run `gulp`
* If gulp complains about missing modules, run `npm install -S <module-name` to resolve the module and re-run `gulp`
* Once gulp runs successfully, open http://localhost:3000/