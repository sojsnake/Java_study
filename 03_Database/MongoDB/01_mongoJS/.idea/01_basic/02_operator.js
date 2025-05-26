//조건 연산자
db.member.find({
    $or: [
        {office : "seoul"},
        {age : 1}
    ]
})

db.member.find({
    $and: [
        {office: "busan"},
        {age : 1}
    ]
})

db.member.find({
    office : {$in: ["busan", "seoul"]}
})

//비교 연산자
db.member.find({
    age : {$gt : 50}
})

db.member.find({
    age : {$lt : 10}
})

db.member.find({
    age:{$gte : 20, $lte : 30}
})

db.member.find({
    office : {$ne : "busan"}
})

//10까지 지우고
db.member.updateMany({
    age: {$gte: 1, $lte: 10}
},{
    $unset :{phone:""}
})

//지운거 제외 출력
db.member.find({
    phone : {$exists: true}
})

db.member.find({
    phone : {$not : {$exists: true}}
})

db.member.find({
    //name이 G로 시작하는 member
    name:{$regex: /^G/}
})