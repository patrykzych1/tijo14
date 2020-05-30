package pl.edu.pwsztar

import spock.lang.Specification

class UserIdSpec extends Specification {

    def idList = ['94012733108', '02041458213', '1010101', 'abcdefabcde', '123bnm']

    def "should check correct size"() {
        given:
            UserId userId = new UserId(idList.get(0))
            UserId userId1 = new UserId(idList.get(1))
            UserId userId2 = new UserId(idList.get(2))
            UserId userId3 = new UserId(idList.get(3))
            UserId userId4 = new UserId(idList.get(4))
        when:
            def result = [userId.isCorrectSize(), userId1.isCorrectSize(), userId2.isCorrectSize(), userId3.isCorrectSize(), userId4.isCorrectSize()]
        then:
            result == [true, true, false, true, false]
    }

    def "should check if sex is valid" (){
        given:
            UserId userId = new UserId(idList.get(0))
            UserId userId1 = new UserId(idList.get(1))
            UserId userId2 = new UserId(idList.get(2))
            UserId userId3 = new UserId(idList.get(3))
            UserId userId4 = new UserId(idList.get(4))
        when:
            def result = [userId.getSex().toString() == "Optional[WOMAN]",
                          userId1.getSex().toString() == "Optional[MAN]",
                          userId2.getSex().toString() == "Optional.empty",
                          userId3.getSex().toString() == "Optional.empty",
                          userId4.getSex().toString() == "Optional.empty"]
        then:
            result == [true, true, true, true, true]
    }

    def "should check if id is correct" () {
        given:
            UserId userId = new UserId(idList.get(0))
            UserId userId1 = new UserId(idList.get(1))
            UserId userId2 = new UserId(idList.get(2))
            UserId userId3 = new UserId(idList.get(3))
            UserId userId4 = new UserId(idList.get(4))
        when:
            def result = [userId.isCorrect(),
                          userId1.isCorrect(),
                          userId2.isCorrect(),
                          userId3.isCorrect(),
                          userId4.isCorrect()]
        then:
            result == [true, true, false, false, false]
    }

    def "should return date (dd-mm-yyyy)" () {
        given:
            UserId userId = new UserId(idList.get(0))
            UserId userId1 = new UserId(idList.get(1))
            UserId userId2 = new UserId(idList.get(2))
            UserId userId3 = new UserId(idList.get(3))
            UserId userId4 = new UserId(idList.get(4))
        when:
            def result = [userId.getDate() == Optional.of('27-01-1994'),
                          userId1.getDate() == Optional.of('14-04-2002'),
                          userId2.getDate() == Optional.empty(),
                          userId3.getDate() == Optional.empty(),
                          userId4.getDate() == Optional.empty()]
        then:
            result == [true, true, true, true, true]
    }
}

