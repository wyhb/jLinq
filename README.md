# java Linq

[Maven Repository jLinq](http://mvnrepository.com/artifact/com.github.wyhb.joe/jLinq/1.0.0.0)

|jLinq|C#|Java 8 Stream|
|:--:|:--:|:--:|
|where|Where|filter|
|select|Select|map|
|orderBy|OrderBy|sorted|
|orderByDescending|OrderByDescending|n/a|
|thenBy|ThenBy|n/a|
|thenByDescending|ThenByDescending|n/a|
|selectMany|SelectMany|flatMap|
|skip|Skip|skip|
|skipWhile|SkipWhile|n/a|
|take|Take|limit|
|takeWhile|TakeWhile|n/a|
|concat|Concat|concat|
|intersect|Intersect|n/a|
|union|Union|n/a|
|except|Except|n/a|
|join|Join|n/a|
|groupJoin|GroupJoin|n/a|
|reverse|Reverse|n/a|
|zip|Zip|n/a|
|distinct|Distinct|distinct|
|aggregate|Aggregate|reduce|
|groupBy|GroupBy|Collectors.groupingBy|
|averageXXX|Average|Collectors.summarizingXXX|
|count|Count|n/a|
|longCount|LongCount|count|
|max|Max|max|
|min|Min|min|
|sumXXX|Sum|Collectors.summarizingXXX|
|first|First|findFirst|
|firstOrDefault|FirstOrDefault|n/a|
|last|Last|n/a|
|lastOrDefault|LastOrDefault|n/a|
|single|Single|n/a|
|singleOrDefault|SingleOrDefault|n/a|
|defaultIfEmpty|DefaultIfEmpty|n/a|
|elementAt|ElementAt|n/a|
|elementAtOrDefault|ElementAtOrDefault|n/a|
|all|All|allMatch|
|any|Any|anyMatch|
|empty|Empty|n/a|
|range|Range|n/a|
|repeat|Repeat|n/a|
|sequenceEqual|SequenceEqual|n/a|
|cast|Cast|n/a|
|ofType|OfType|n/a|

Usage:

**where<br>
```
List<Integer> listWhere = new List<>(1, 2, 3);

List<Integer> actualWhere = listWhere.where(x -> x == 1 || x == 3).toList();

assertEquals(true , actualWhere.contains(1));
assertEquals(false, actualWhere.contains(2));
assertEquals(true , actualWhere.contains(3));
```
**select**
```
List<Person> listSelect = new List<>(
        new Person("React"   , 1),
        new Person("Angular" , 3),
        new Person("Backbone", 5)
);

List<String> actualSelect = listSelect.select(x -> x.name).toList();

assertEquals("React"   , actualSelect.get(0));
assertEquals("Angular" , actualSelect.get(1));
assertEquals("Backbone", actualSelect.get(2));
```
**orderBy**
```
List<String> listOrderBy = new List<>("Backbone", "Angular", "React");

List<String> actualOrderBy = listOrderBy.orderBy(x -> x).toList();

assertEquals("Angular" , actualOrderBy.get(0));
assertEquals("Backbone", actualOrderBy.get(1));
assertEquals("React"   , actualOrderBy.get(2));
```
**orderByDescending**
```
List<String> listOrderByDescending = new List<>("Backbone", "Angular", "React");

List<String> actualOrderByDescending = listOrderByDescending.orderByDescending(x -> x).toList();

assertEquals("React"   , actualOrderByDescending.get(0));
assertEquals("Backbone", actualOrderByDescending.get(1));
assertEquals("Angular" , actualOrderByDescending.get(2));
```
**thenBy**
```
List<Person> listThenBy = new List<>(
        new Person("Angular2", 2),
        new Person("Angular1", 2),
        new Person("React"   , 1)
);

List<Person> actualThenBy = listThenBy.orderBy(x -> x.age).thenBy(x -> x.name).toList();

assertEquals("React" , actualThenBy.get(0).name);
assertEquals("Angular1", actualThenBy.get(1).name);
assertEquals("Angular2"   , actualThenBy.get(2).name);
```
**thenByDescending**
```
List<Person> listThenByDescending = new List<>(
        new Person("Angular2", 2),
        new Person("Angular1", 2),
        new Person("React"   , 1)
);

List<Person> actualThenByDescending = listThenByDescending.orderBy(x -> x.age).thenByDescending(x -> x.name).toList();

assertEquals("React" , actualThenByDescending.get(0).name);
assertEquals("Angular2", actualThenByDescending.get(1).name);
assertEquals("Angular1"   , actualThenByDescending.get(2).name);
```
**selectMany**
```
List<Person> listSelectMany = new List<>(
        new Person("Angular", 3, new List("1.0.1", "1.0.2")),
        new Person("React"  , 1, new List("2.0.1", "2.0.2"))
);

List<Object> actualSelectMany =listSelectMany.selectMany(x -> x.versionHistory).toList();

assertEquals("1.0.1", actualSelectMany.get(0));
assertEquals("1.0.2", actualSelectMany.get(1));
assertEquals("2.0.1", actualSelectMany.get(2));
assertEquals("2.0.2", actualSelectMany.get(3));
```
**skip**
```
List<Integer> listSkip = new List<>(1, 2, 3);

List<Integer> actualSkip = listSkip.skip(2).toList();

assertEquals(3, actualSkip.get(0).intValue());
```
**skipWhile**
```
List<Integer> listSkipWhile = new List<>(1, 2, 3, 4, 5);

List<Integer> actualSkipWhile = listSkipWhile.skipWhile(x -> x <= 3).toList();

assertEquals(4, actualSkipWhile.get(0).intValue());
assertEquals(5, actualSkipWhile.get(1).intValue());
```
**take**
```
List<String> listTake = new List<>("Backbone", "Angular", "React");

List<String> actualTake = listTake.take(2).toList();

assertEquals(2, actualTake.size());
assertEquals("Backbone", actualTake.get(0));
assertEquals("Angular" , actualTake.get(1));
```
**takeWhile**
```
List<String> listTakeWhile = new List<>("Backbone", "Angular", "React");

List<String> actualTakeWhile = listTakeWhile.takeWhile(x -> x.equals("Backbone") || x.equals("Angular")).toList();

assertEquals(2, actualTakeWhile.size());
assertEquals("Backbone", actualTakeWhile.get(0));
assertEquals("Angular" , actualTakeWhile.get(1));
```
**concat**
```
List<Integer> firstConcat  = new List<>(1, 2);
List<Integer> secondConcat= new List<>(2, 3);

List<Integer> actualConcat = firstConcat.concat(secondConcat).toList();

assertEquals(1, actualConcat.get(0).intValue());
assertEquals(2, actualConcat.get(1).intValue());
assertEquals(2, actualConcat.get(2).intValue());
assertEquals(3, actualConcat.get(3).intValue());
```
**intersect**
```
List<Integer> firstIntersect  = new List<>(1, 2, 3);
List<Integer> secondIntersect = new List<>(1, 3);

List<Integer> actualIntersect = firstIntersect.intersect(secondIntersect).toList();

assertEquals(1, actualIntersect.get(0).intValue());
assertEquals(3, actualIntersect.get(1).intValue());
```
**union**
```
List<Integer> firstUnion = new List<>(1, 2, 3);
List<Integer> secondUnion = new List<>(0, 1, 3, 4);

List<Integer> actualUnion = firstUnion.union(secondUnion).toList();

assertEquals(5, actualUnion.size());
assertEquals(1, actualUnion.get(0).intValue());
assertEquals(2, actualUnion.get(1).intValue());
assertEquals(3, actualUnion.get(2).intValue());
assertEquals(0, actualUnion.get(3).intValue());
assertEquals(4, actualUnion.get(4).intValue());
```
**except**
```
List<Integer> firstExcept  = new List<>(1, 2, 3);
List<Integer> secondExcept = new List<>(1, 3);

List<Integer> actualExcept = firstExcept.except(secondExcept).toList();

assertEquals(2, actualExcept.get(0).intValue());
```
**join**
```
List<Person> outerJoin = new List<>(
        new Person("Angular", 1),
        new Person("React"  , 4),
        new Person("ES2016" , 5)
);
List<Person> innerJoin = new List<>(
        new Person("Angular", 2),
        new Person("Angular", 3),
        new Person("ES2016" , 6),
        new Person("ES7"    , 7)
);

Function<Person, String> outerKeyJoin = (x) -> x.name;
Function<Person, String> innerKeyJoin = (y) -> y.name;
BiFunction<Person, Person, Person> selectorJoin = (x, y) -> new Person(x.name, y.age);
List<Person> actualJoin = outerJoin.join(innerJoin, outerKeyJoin, innerKeyJoin, selectorJoin).toList();

assertEquals(3, actualJoin.size());
assertEquals("Angular", actualJoin.get(0).name);
assertEquals("Angular", actualJoin.get(1).name);
assertEquals("ES2016" , actualJoin.get(2).name);
assertEquals(2, actualJoin.get(0).age);
assertEquals(3, actualJoin.get(1).age);
assertEquals(6, actualJoin.get(2).age);
```
**groupJoin**
```
List<Person> outerGroupJoin = new List<>(
        new Person("Angular", 1),
        new Person("React"  , 4),
        new Person("ES2016" , 5)
);
List<Person> innerGroupJoin = new List<>(
        new Person("Angular", 2),
        new Person("Angular", 3),
        new Person("ES2016" , 6),
        new Person("ES7"    , 7)
);

Function<Person, String> outerKeyGroupJoin = (x) -> x.name;
Function<Person, String> innerKeyGroupJoin= (y) -> y.name;
BiFunction<Person, IEnumerable<Person>, Person> selectorGroupJoin = (x, y) -> new Person(x.name, y.select(z -> z.age));
List<Person> actualGroupJoin = outerGroupJoin.groupJoin(innerGroupJoin, outerKeyGroupJoin, innerKeyGroupJoin, selectorGroupJoin).toList();

assertEquals(3, actualGroupJoin.size());
assertEquals("Angular", actualGroupJoin.get(0).name);
assertEquals("React"  , actualGroupJoin.get(1).name);
assertEquals("ES2016" , actualGroupJoin.get(2).name);
assertEquals(2, actualGroupJoin.get(0).ages.elementAt(0));
assertEquals(3, actualGroupJoin.get(0).ages.elementAt(1));
assertEquals(0, actualGroupJoin.get(1).ages.count());
assertEquals(6, actualGroupJoin.get(2).ages.elementAt(0));
```
**reverse**
```
List<Integer> listReverse = new List<>(1, 2, 3);

List<Integer> actualReverse = listReverse.reverse().toList();

assertEquals(3, actualReverse.get(0).intValue());
assertEquals(2, actualReverse.get(1).intValue());
assertEquals(1, actualReverse.get(2).intValue());
```
**zip**
```
List<Integer> firstZip = new List<>(1, 2, 3);
List<String> secondZip = new List<>("Angular", "React", "Backbone");

List<String> actualZip = firstZip.zip(secondZip, (x, y) -> String.format("%d %s", x, y)).toList();

assertEquals("1 Angular" , actualZip.get(0));
assertEquals("2 React"   , actualZip.get(1));
assertEquals("3 Backbone", actualZip.get(2));
```
**distinct**
```
List<Integer> listDistinct =
        new List<>(
                1, 2, 3,
                1, 2, 3, 4
        );

List<Integer> actualDistinct = listDistinct.distinct().toList();

assertEquals(1, actualDistinct.get(0).intValue());
assertEquals(2, actualDistinct.get(1).intValue());
assertEquals(3, actualDistinct.get(2).intValue());
assertEquals(4, actualDistinct.get(3).intValue());
```
**aggregate**
```
List<Integer> listAggregate = new List<>(1, 2, 3);

int actualAggregate = listAggregate.aggregate((sum, elem) -> sum + elem);

assertEquals(6, actualAggregate);

// groupBy<br>
List<Person> listGroupBy = new List<>(
        new Person("React"   , 1),
        new Person("Angular" , 1),
        new Person("Backbone", 5)
);

Map<Integer, IEnumerable<Person>> actualGroupBy = listGroupBy.groupBy(x -> x.age);

assertEquals(true, actualGroupBy.get(1).any(x -> x.name.equals("React")));
assertEquals(true, actualGroupBy.get(1).any(x -> x.name.equals("Angular")));
assertEquals(true, actualGroupBy.get(5).any(x -> x.name.equals("Backbone")));
```
**average**
```
List<Long> listLongAverage = new List<>(1l, 2l, 3l, 4l);

double actualLongAverage = listLongAverage.averageLong(x -> x);

assertEquals(2.5d, actualLongAverage, 0);
```
**count**
```
List<String> listCount = new List<>("Backbone", "Angular", "React");

long actualCount = listCount.longCount();
int actualNoneCount = listCount.count(x -> x.equals("jquery"));

assertEquals(3, actualCount);
assertEquals(0, actualNoneCount);
```
**max**
```
List<Double> listDoubleMax = new List<>(1d, 2d, 3d);

double actualDoubleMax = listDoubleMax.max(x -> x);

assertEquals(3d, actualDoubleMax, 0);
```
**min**
```
List<BigDecimal> listBigDecimalMin = new List<>(
        new BigDecimal(1d),
        new BigDecimal(2d),
        new BigDecimal(3d)
);

BigDecimal actualBigDecimalMin = listBigDecimalMin.min(x -> x);

assertEquals(1d, actualBigDecimalMin.doubleValue(), 0);
```
**sum**
```
List<Integer> listIntSum = new List<>(1, 2, 3);

int actualIntSum = listIntSum.sumInt(x -> x);

assertEquals(6, actualIntSum);
```
**firstOrDefault**
```
List<String> listFirstOrDefault = new List<>("Backbone", "Angular", "React");

String actualFirstFirstOrDefault   = listFirstOrDefault.firstOrDefault();
String actualMatchFirstOrDefault   = listFirstOrDefault.firstOrDefault(x -> x.equals("Angular"));
String actualUnMatchFirstOrDefault = listFirstOrDefault.firstOrDefault(x -> x.equals("jquery"));

assertEquals("Backbone", actualFirstFirstOrDefault);
assertEquals("Angular" , actualMatchFirstOrDefault);
assertEquals(null      , actualUnMatchFirstOrDefault);
```
**lastOrDefault**
```
List<Integer> listLastOrDefault = new List<>(1, 2, 3);
List<Integer> listEmptyLastOrDefault = new List<>();

int actualLastOrDefault = listLastOrDefault.lastOrDefault();
Integer actualDefaultNoneLastOrDefault = listEmptyLastOrDefault.lastOrDefault(x -> x == 0);

assertEquals(3, actualLastOrDefault);
assertEquals(null, actualDefaultNoneLastOrDefault);
```
**singleOrDefault**
```
List<Integer> listManySingleOrDefault = new List<>(1, 2, 3);
List<Integer> listEmptySingleOrDefault = new List<>();

int actualFilterSingleOrDefault = listManySingleOrDefault.singleOrDefault(x -> x == 3);
Integer actualUnMatchSingleOrDefault = listEmptySingleOrDefault.singleOrDefault(x -> x == 0);

assertEquals(3, actualFilterSingleOrDefault);
assertEquals(null, actualUnMatchSingleOrDefault);
```
**defaultIfEmpty**
```
List<String> listEmpty = new List<>();

List<String> actualDefault = listEmpty.defaultIfEmpty("ES7").toList();

assertEquals("ES7", actualDefault.get(0));
```
**elementAtOrDefault**
```
List<Integer> listElementAtOrDefault = new List<>(1, 2, 3);

int actualElementAtOrDefault = listElementAtOrDefault.elementAtOrDefault(2);
Integer actualDefaultElementAtOrDefault = listElementAtOrDefault.elementAtOrDefault(3);

assertEquals(3, actualElementAtOrDefault);
assertEquals(null, actualDefaultElementAtOrDefault);
```
**all**
```
List<String> listAll = new List<>("Backbone", "Angular", "React");

boolean actualAll = listAll.all(x -> x.equals("Angular") || x.equals("Backbone") || x.equals("React"));
boolean actualNotFoundAll = listAll.all(x -> x.equals("Angular") || x.equals("React"));

assertEquals(true, actualAll);
assertEquals(false, actualNotFoundAll);
```
**any**
```
List<String> listAny = new List<>("Backbone", "Angular", "React");

boolean actualAny = listAny.any(x -> x.equals("Angular"));
boolean actualNotFoundAny = listAny.any(x -> x.equals("jquery"));

assertEquals(true, actualAny);
assertEquals(false, actualNotFoundAny);
```
**empty**
```
List<Double> actualEmpty = IEnumerable.empty(Double.class);

assertEquals(0, actualEmpty.count());
```
**range**
```
List<Integer> actualRange = IEnumerable.range(-2, 3);

assertEquals(-2, actualRange.get(0).intValue());
assertEquals(-1, actualRange.get(1).intValue());
assertEquals(0 , actualRange.get(2).intValue());
```
**repeat**
```
List<String> actualRepeat = IEnumerable.repeat(String.class, "Law of Cycles", 10);

assertEquals(10, actualRepeat.count());
assertEquals("Law of Cycles", actualRepeat.get(9));
```
**sequenceEqual**
```
List<Integer> firstSequenceEqual = new List<>(1, 2, 3);
List<Integer> secondMatchSequenceEqual = new List<>(1, 2, 3);
List<Integer> secondUnMatchElemSequenceEqual = new List<>(1, 2, 4);

boolean actualMatchSequenceEqual = firstSequenceEqual.sequenceEqual(secondMatchSequenceEqual);
boolean actualUnMatchElmSequenceEqual = firstSequenceEqual.sequenceEqual(secondUnMatchElemSequenceEqual);

assertEquals(true, actualMatchSequenceEqual);
assertEquals(false, actualUnMatchElmSequenceEqual);
```
**cast**
```
List<Object> listCast = new List<>(1, 2, 3);

List<Integer> actualCast = listCast.cast(Integer.class).toList();

assertEquals(1, actualCast.get(0).intValue());
assertEquals(2, actualCast.get(1).intValue());
assertEquals(3, actualCast.get(2).intValue());
```
**ofType**
```
List<Object> listOfType = new List<>(1, "2", 3, "4");

List<String>  actualStrOfType = listOfType.ofType(String.class).toList();
List<Integer> actualIntOfType = listOfType.ofType(Integer.class).toList();

assertEquals("2", actualStrOfType.get(0));
assertEquals("4", actualStrOfType.get(1));
assertEquals(1  , actualIntOfType.get(0).intValue());
assertEquals(3  , actualIntOfType.get(1).intValue());
```
