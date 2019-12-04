![Karumi logo][karumilogo] Kata Magic Counter for Kotlin. [![Build Status](https://travis-ci.com/Karumi/MagicCounterKataAndroid.svg?branch=master)](https://travis-ci.com/Karumi/MagicCounterKataAndroid)
=========================================================

- We are here to practice unit and integration testing
- We are going to use JUnit and instrumentation tests.
- We are going to practice pair programming.

During this kata we will try to find how to use unit and instrumentation tests properly:

* Using unit and integration tests.
* Writing test doubles manually.
* Using the already tested code to check if the tests are working fine (manual mutation testing).

## Getting started

Once upon a time, there was a magic counter we have to implement now. This magic counter was persistent and it could be incremented and decremented. The magic counter follows these rules:

* If there was no a previously counter value saved we will assume the value is 0.
* When incremented the persistent value of the counter is obtained and a random number generator emits a random integer value.
  * If the random value is greater than 100 the counter value is incremented with the random value and saved.
  * If the random value is not greater than 100 the counter value is incremented by one and saved.
* When decremented the value is decremented by 1.

## Tasks

Your task as AndroidDeveloper is to resolve this problem and add coverage to your implementation.

* If you want to practice TDD write a little piece of software to implement the already described scenario following the TDD cycle.
* If you don not want to follow the TDD path create an empty project, and use JUnit to test your program.

# License

Copyright 2019 Karumi

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

  http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

[karumilogo]: https://cloud.githubusercontent.com/assets/858090/11626547/e5a1dc66-9ce3-11e5-908d-537e07e82090.png