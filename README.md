# java Linq
|jLinq|C#|Stream|
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

// where
List<Integer> listWhere = new List<>(1, 2, 3);<br>

List<Integer> actualWhere = listWhere.where(x -> x == 1 || x == 3).toList();<br>

assertEquals(true , actualWhere.contains(1));<br>
assertEquals(false, actualWhere.contains(2));<br>
assertEquals(true , actualWhere.contains(3));<br>

// select
List<Person> listSelect = new List<>(
        new Person("React"   , 1),
        new Person("Angular" , 3),
        new Person("Backbone", 5)
);<br>

List<String> actualSelect = listSelect.select(x -> x.name).toList();<br>

assertEquals("React"   , actualSelect.get(0));<br>
assertEquals("Angular" , actualSelect.get(1));<br>
assertEquals("Backbone", actualSelect.get(2));<br>

// orderBy
List<String> listOrderBy = new List<>("Backbone", "Angular", "React");<br>

List<String> actualOrderBy = listOrderBy.orderBy(x -> x).toList();<br>

assertEquals("Angular" , actualOrderBy.get(0));<br>
assertEquals("Backbone", actualOrderBy.get(1));<br>
assertEquals("React"   , actualOrderBy.get(2));<br>

// orderByDescending
List<String> listOrderByDescending = new List<>("Backbone", "Angular", "React");<br>

List<String> actualOrderByDescending = listOrderByDescending.orderByDescending(x -> x).toList();<br>

assertEquals("React"   , actualOrderByDescending.get(0));<br>
assertEquals("Backbone", actualOrderByDescending.get(1));<br>
assertEquals("Angular" , actualOrderByDescending.get(2));<br>

// thenBy
List<Person> listThenBy = new List<>(
        new Person("Angular2", 2),
        new Person("Angular1", 2),
        new Person("React"   , 1)
);<br>

List<Person> actualThenBy = listThenBy.orderBy(x -> x.age).thenBy(x -> x.name).toList();<br>

assertEquals("React" , actualThenBy.get(0).name);<br>
assertEquals("Angular1", actualThenBy.get(1).name);<br>
assertEquals("Angular2"   , actualThenBy.get(2).name);<br>

// thenByDescending
List<Person> listThenByDescending = new List<>(
        new Person("Angular2", 2),
        new Person("Angular1", 2),
        new Person("React"   , 1)
);<br>

List<Person> actualThenByDescending = listThenByDescending.orderBy(x -> x.age).thenByDescending(x -> x.name).toList();<br>

assertEquals("React" , actualThenByDescending.get(0).name);<br>
assertEquals("Angular2", actualThenByDescending.get(1).name);<br>
assertEquals("Angular1"   , actualThenByDescending.get(2).name);<br>

// selectMany
List<Person> listSelectMany = new List<>(
        new Person("Angular", 3, new List("1.0.1", "1.0.2")),
        new Person("React"  , 1, new List("2.0.1", "2.0.2"))
);<br>

List<Object> actualSelectMany =listSelectMany.selectMany(x -> x.versionHistory).toList();<br>

assertEquals("1.0.1", actualSelectMany.get(0));<br>
assertEquals("1.0.2", actualSelectMany.get(1));<br>
assertEquals("2.0.1", actualSelectMany.get(2));<br>
assertEquals("2.0.2", actualSelectMany.get(3));<br>

// skip
List<Integer> listSkip = new List<>(1, 2, 3);<br>

List<Integer> actualSkip = listSkip.skip(2).toList();<br>

assertEquals(3, actualSkip.get(0).intValue());<br>

// skipWhile
List<Integer> listSkipWhile = new List<>(1, 2, 3, 4, 5);<br>

List<Integer> actualSkipWhile = listSkipWhile.skipWhile(x -> x <= 3).toList();<br>

assertEquals(4, actualSkipWhile.get(0).intValue());<br>
assertEquals(5, actualSkipWhile.get(1).intValue());<br>

// take
List<String> listTake = new List<>("Backbone", "Angular", "React");<br>

List<String> actualTake = listTake.take(2).toList();<br>

assertEquals(2, actualTake.size());<br>
assertEquals("Backbone", actualTake.get(0));<br>
assertEquals("Angular" , actualTake.get(1));<br>

// takeWhile
List<String> listTakeWhile = new List<>("Backbone", "Angular", "React");<br>

List<String> actualTakeWhile = listTakeWhile.takeWhile(x -> x.equals("Backbone") || x.equals("Angular")).toList();<br>

assertEquals(2, actualTakeWhile.size());<br>
assertEquals("Backbone", actualTakeWhile.get(0));<br>
assertEquals("Angular" , actualTakeWhile.get(1));<br>

// concat
List<Integer> firstConcat  = new List<>(1, 2);<br>
List<Integer> secondConcat= new List<>(2, 3);<br>

List<Integer> actualConcat = firstConcat.concat(secondConcat).toList();<br>

assertEquals(1, actualConcat.get(0).intValue());<br>
assertEquals(2, actualConcat.get(1).intValue());<br>
assertEquals(2, actualConcat.get(2).intValue());<br>
assertEquals(3, actualConcat.get(3).intValue());<br>

// intersect
List<Integer> firstIntersect  = new List<>(1, 2, 3);<br>
List<Integer> secondIntersect = new List<>(1, 3);<br>

List<Integer> actualIntersect = firstIntersect.intersect(secondIntersect).toList();<br>

assertEquals(1, actualIntersect.get(0).intValue());<br>
assertEquals(3, actualIntersect.get(1).intValue());<br>

// union
List<Integer> firstUnion = new List<>(1, 2, 3);<br>
List<Integer> secondUnion = new List<>(0, 1, 3, 4);<br>

List<Integer> actualUnion = firstUnion.union(secondUnion).toList();<br>

assertEquals(5, actualUnion.size());<br>
assertEquals(1, actualUnion.get(0).intValue());<br>
assertEquals(2, actualUnion.get(1).intValue());<br>
assertEquals(3, actualUnion.get(2).intValue());<br>
assertEquals(0, actualUnion.get(3).intValue());<br>
assertEquals(4, actualUnion.get(4).intValue());<br>

// except
List<Integer> firstExcept  = new List<>(1, 2, 3);<br>
List<Integer> secondExcept = new List<>(1, 3);<br>

List<Integer> actualExcept = firstExcept.except(secondExcept).toList();<br>

assertEquals(2, actualExcept.get(0).intValue());<br>

// join
List<Person> outerJoin = new List<>(
        new Person("Angular", 1),
        new Person("React"  , 4),
        new Person("ES2016" , 5)
);<br>
List<Person> innerJoin = new List<>(
        new Person("Angular", 2),
        new Person("Angular", 3),
        new Person("ES2016" , 6),
        new Person("ES7"    , 7)
);<br>

Function<Person, String> outerKeyJoin = (x) -> x.name;<br>
Function<Person, String> innerKeyJoin = (y) -> y.name;<br>
BiFunction<Person, Person, Person> selectorJoin = (x, y) -> new Person(x.name, y.age);<br>
List<Person> actualJoin = outerJoin.join(innerJoin, outerKeyJoin, innerKeyJoin, selectorJoin).toList();<br>

assertEquals(3, actualJoin.size());<br>
assertEquals("Angular", actualJoin.get(0).name);<br>
assertEquals("Angular", actualJoin.get(1).name);<br>
assertEquals("ES2016" , actualJoin.get(2).name);<br>
assertEquals(2, actualJoin.get(0).age);<br>
assertEquals(3, actualJoin.get(1).age);<br>
assertEquals(6, actualJoin.get(2).age);<br>

// groupJoin
List<Person> outerGroupJoin = new List<>(
        new Person("Angular", 1),
        new Person("React"  , 4),
        new Person("ES2016" , 5)
);<br>
List<Person> innerGroupJoin = new List<>(
        new Person("Angular", 2),
        new Person("Angular", 3),
        new Person("ES2016" , 6),
        new Person("ES7"    , 7)
);<br>

Function<Person, String> outerKeyGroupJoin = (x) -> x.name;<br>
Function<Person, String> innerKeyGroupJoin= (y) -> y.name;<br>
BiFunction<Person, IEnumerable<Person>, Person> selectorGroupJoin = (x, y) -> new Person(x.name, y.select(z -> z.age));<br>
List<Person> actualGroupJoin = outerGroupJoin.groupJoin(innerGroupJoin, outerKeyGroupJoin, innerKeyGroupJoin, selectorGroupJoin).toList();<br>

assertEquals(3, actualGroupJoin.size());<br>
assertEquals("Angular", actualGroupJoin.get(0).name);<br>
assertEquals("React"  , actualGroupJoin.get(1).name);<br>
assertEquals("ES2016" , actualGroupJoin.get(2).name);<br>
assertEquals(2, actualGroupJoin.get(0).ages.elementAt(0));<br>
assertEquals(3, actualGroupJoin.get(0).ages.elementAt(1));<br>
assertEquals(0, actualGroupJoin.get(1).ages.count());<br>
assertEquals(6, actualGroupJoin.get(2).ages.elementAt(0));<br>

// reverse
List<Integer> listReverse = new List<>(1, 2, 3);<br>

List<Integer> actualReverse = listReverse.reverse().toList();<br>

assertEquals(3, actualReverse.get(0).intValue());<br>
assertEquals(2, actualReverse.get(1).intValue());<br>
assertEquals(1, actualReverse.get(2).intValue());<br>

// zip
List<Integer> firstZip = new List<>(1, 2, 3);<br>
List<String> secondZip = new List<>("Angular", "React", "Backbone");<br>

List<String> actualZip = firstZip.zip(secondZip, (x, y) -> String.format("%d %s", x, y)).toList();<br>

assertEquals("1 Angular" , actualZip.get(0));<br>
assertEquals("2 React"   , actualZip.get(1));<br>
assertEquals("3 Backbone", actualZip.get(2));<br>

// distinct
List<Integer> listDistinct =
        new List<>(
                1, 2, 3,
                1, 2, 3, 4
        );<br>

List<Integer> actualDistinct = listDistinct.distinct().toList();<br>

assertEquals(1, actualDistinct.get(0).intValue());<br>
assertEquals(2, actualDistinct.get(1).intValue());<br>
assertEquals(3, actualDistinct.get(2).intValue());<br>
assertEquals(4, actualDistinct.get(3).intValue());<br>

// aggregate
List<Integer> listAggregate = new List<>(1, 2, 3);<br>

int actualAggregate = listAggregate.aggregate((sum, elem) -> sum + elem);<br>

assertEquals(6, actualAggregate);<br>

// groupBy
List<Person> listGroupBy = new List<>(
        new Person("React"   , 1),
        new Person("Angular" , 1),
        new Person("Backbone", 5)
);<br>

Map<Integer, IEnumerable<Person>> actualGroupBy = listGroupBy.groupBy(x -> x.age);<br>

assertEquals(true, actualGroupBy.get(1).any(x -> x.name.equals("React")));<br>
assertEquals(true, actualGroupBy.get(1).any(x -> x.name.equals("Angular")));<br>
assertEquals(true, actualGroupBy.get(5).any(x -> x.name.equals("Backbone")));<br>

// average
List<Long> listLongAverage = new List<>(1l, 2l, 3l, 4l);<br>

double actualLongAverage = listLongAverage.averageLong(x -> x);<br>

assertEquals(2.5d, actualLongAverage, 0);<br>

// count
List<String> listCount = new List<>("Backbone", "Angular", "React");<br>

long actualCount = listCount.longCount();<br>
int actualNoneCount = listCount.count(x -> x.equals("jquery"));<br>

assertEquals(3, actualCount);<br>
assertEquals(0, actualNoneCount);<br>

// max
List<Double> listDoubleMax = new List<>(1d, 2d, 3d);<br>

double actualDoubleMax = listDoubleMax.max(x -> x);<br>

assertEquals(3d, actualDoubleMax, 0);<br>

// min
List<BigDecimal> listBigDecimalMin = new List<>(
        new BigDecimal(1d),
        new BigDecimal(2d),
        new BigDecimal(3d)
);<br>

BigDecimal actualBigDecimalMin = listBigDecimalMin.min(x -> x);<br>

assertEquals(1d, actualBigDecimalMin.doubleValue(), 0);<br>

// sum
List<Integer> listIntSum = new List<>(1, 2, 3);<br>

int actualIntSum = listIntSum.sumInt(x -> x);<br>

assertEquals(6, actualIntSum);<br>

// firstOrDefault
List<String> listFirstOrDefault = new List<>("Backbone", "Angular", "React");<br>

String actualFirstFirstOrDefault   = listFirstOrDefault.firstOrDefault();<br>
String actualMatchFirstOrDefault   = listFirstOrDefault.firstOrDefault(x -> x.equals("Angular"));<br>
String actualUnMatchFirstOrDefault = listFirstOrDefault.firstOrDefault(x -> x.equals("jquery"));<br>

assertEquals("Backbone", actualFirstFirstOrDefault);<br>
assertEquals("Angular" , actualMatchFirstOrDefault);<br>
assertEquals(null      , actualUnMatchFirstOrDefault);<br>

// lastOrDefault
List<Integer> listLastOrDefault = new List<>(1, 2, 3);<br>
List<Integer> listEmptyLastOrDefault = new List<>();<br>

int actualLastOrDefault = listLastOrDefault.lastOrDefault();<br>
Integer actualDefaultNoneLastOrDefault = listEmptyLastOrDefault.lastOrDefault(x -> x == 0);<br>

assertEquals(3, actualLastOrDefault);<br>
assertEquals(null, actualDefaultNoneLastOrDefault);<br>

// singleOrDefault
List<Integer> listManySingleOrDefault = new List<>(1, 2, 3);<br>
List<Integer> listEmptySingleOrDefault = new List<>();<br>

int actualFilterSingleOrDefault = listManySingleOrDefault.singleOrDefault(x -> x == 3);<br>
Integer actualUnMatchSingleOrDefault = listEmptySingleOrDefault.singleOrDefault(x -> x == 0);<br>

assertEquals(3, actualFilterSingleOrDefault);<br>
assertEquals(null, actualUnMatchSingleOrDefault);<br>

// defaultIfEmpty
List<String> listEmpty = new List<>();<br>

List<String> actualDefault = listEmpty.defaultIfEmpty("ES7").toList();<br>

assertEquals("ES7", actualDefault.get(0));<br>

// elementAtOrDefault
List<Integer> listElementAtOrDefault = new List<>(1, 2, 3);<br>

int actualElementAtOrDefault = listElementAtOrDefault.elementAtOrDefault(2);<br>
Integer actualDefaultElementAtOrDefault = listElementAtOrDefault.elementAtOrDefault(3);<br>

assertEquals(3, actualElementAtOrDefault);<br>
assertEquals(null, actualDefaultElementAtOrDefault);<br>

// all
List<String> listAll = new List<>("Backbone", "Angular", "React");<br>

boolean actualAll = listAll.all(x -> x.equals("Angular") || x.equals("Backbone") || x.equals("React"));<br>
boolean actualNotFoundAll = listAll.all(x -> x.equals("Angular") || x.equals("React"));<br>

assertEquals(true, actualAll);<br>
assertEquals(false, actualNotFoundAll);<br>

// any
List<String> listAny = new List<>("Backbone", "Angular", "React");<br>

boolean actualAny = listAny.any(x -> x.equals("Angular"));<br>
boolean actualNotFoundAny = listAny.any(x -> x.equals("jquery"));<br>

assertEquals(true, actualAny);<br>
assertEquals(false, actualNotFoundAny);<br>

// empty
List<Double> actualEmpty = IEnumerable.empty(Double.class);<br>

assertEquals(0, actualEmpty.count());<br>

// range
List<Integer> actualRange = IEnumerable.range(-2, 3);<br>

assertEquals(-2, actualRange.get(0).intValue());<br>
assertEquals(-1, actualRange.get(1).intValue());<br>
assertEquals(0 , actualRange.get(2).intValue());<br>

// repeat
List<String> actualRepeat = IEnumerable.repeat(String.class, "Law of Cycles", 10);<br>

assertEquals(10, actualRepeat.count());<br>
assertEquals("Law of Cycles", actualRepeat.get(9));<br>

// sequenceEqual
List<Integer> firstSequenceEqual = new List<>(1, 2, 3);<br>
List<Integer> secondMatchSequenceEqual = new List<>(1, 2, 3);<br>
List<Integer> secondUnMatchElemSequenceEqual = new List<>(1, 2, 4);<br>

boolean actualMatchSequenceEqual = firstSequenceEqual.sequenceEqual(secondMatchSequenceEqual);<br>
boolean actualUnMatchElmSequenceEqual = firstSequenceEqual.sequenceEqual(secondUnMatchElemSequenceEqual);<br>

assertEquals(true, actualMatchSequenceEqual);<br>
assertEquals(false, actualUnMatchElmSequenceEqual);<br>

// cast
List<Object> listCast = new List<>(1, 2, 3);<br>

List<Integer> actualCast = listCast.cast(Integer.class).toList();<br>

assertEquals(1, actualCast.get(0).intValue());<br>
assertEquals(2, actualCast.get(1).intValue());<br>
assertEquals(3, actualCast.get(2).intValue());<br>

// ofType
List<Object> listOfType = new List<>(1, "2", 3, "4");<br>

List<String>  actualStrOfType = listOfType.ofType(String.class).toList();<br>
List<Integer> actualIntOfType = listOfType.ofType(Integer.class).toList();<br>

assertEquals("2", actualStrOfType.get(0));<br>
assertEquals("4", actualStrOfType.get(1));<br>
assertEquals(1  , actualIntOfType.get(0).intValue());<br>
assertEquals(3  , actualIntOfType.get(1).intValue());<br>
