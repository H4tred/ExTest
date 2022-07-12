| Method                                            | Működése                                                                                                                                                                                                                                              |
|---------------------------------------------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| assertEquals(expected, result, message)           | Akkor sikeres a teszteset, ha az expected és a result egyenlő (object esetén meghívja az equals() metódust). A message egy nem kötelező paraméter, amely megadja, hogy ha a teszteset elszáll, akkor milyen üzentet adjon vissza. (ez mindenhol igaz) |
| assertArrayEquals(expected, result, message)      | Akkor sikeres a teszteset, ha az expected és a result tömb azonos. Fontos,hogy számít a sorrend és az elem szám is!                                                                                                                                   |
| assertIterableEquals(expected, result, message)   | Akkor sikeres a teszteset, ha az expected és a result Iterable interface-t megvalósító objektum azonos. Fontos, hogy számít a sorrend és az elem szám is!                                                                                             |
| assertNotEquals(expected, result, message)        | Akkor sikeres a teszteset, ha az expected és a result nem egyenlő (Object esetén meghívja az equals() metódust).                                                                                                                                      |
| assertTrue(result, message)                       | Akkor sikeres a teszteset, ha a result igaz értékű                                                                                                                                                                                                    |
| assertThrows(expected, executable, message)       | Akkor sikeres a teszteset, ha az executable (legtöbbször lambda expression) dobja az adott exceptiont. Úgy szoktuk vizsgálni, hogy adunk egy lambda kifejezést, amelyen belül meghívjuk a saját függvényünket.                                        |
| assertDoesNotThrow(expected, executable, message) | Akkor sikeres a teszteset, ha az executable (legtöbbször lambda expression) nem dobja az adott exceptiont. Úgy szoktuk vizsgálni, hogy adunk egy lambda kifejezést, amelyen belül meghívjuk a saját függvényünket.                                    |
| assertNull(result, message)                       | Akkor sikeres a teszteset, ha a result objektum null.                                                                                                                                                                                                 |
| assertNotNull(result, message)                    | Akkor sikeres a teszteset, ha a result objektum nem null.                                                                                                                                                                                             |
| assertSame(expected, result, message)             | Akkor sikeres a teszteset, ha a result objektum megegyezik az expected objektummal. Itt fontos megjegyezni, hogy akkor egyezik két objektum, ha referenciáik megegyeznek!                                                                             |
| assertNotSame(expected, result, message)          | Akkor sikeres a teszteset, ha a result objektum nem egyezik az expected objektummal. Akkor nem egyezik meg 2 objektum, ha referciáik különbözőek!                                                                                                     |
| assertTimeout(expected, executable, message)      | Akkor sikeres a teszteset, ha az executable (legtöbbször lambda expression) lefut az expected által meghatározott idő alatt.                                                                                                                          |
| assertAll(executable)                             | Csoportosíthatunk vele ellenőrzéseket. Egymásba is ágyazhatók. (lásd későbbi példák)                                                                                                                                                                  |
| fail(message)                                     | Sikertelenné tesz egy tesztesetet, ha meghívjuk                                                                                                                                                                                                       |