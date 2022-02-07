// 기능개발

/*
< 알고리즘 >
(1) 100 - 작업진도 = x , x / 작업속도 = a, x % 작업속도 = b
(2) b가 있으면 a+1, b가 없으면 a를 큐에 저장
(3) 큐에서 pop하면서 해당 값보다 작거나 같은 값이 있으면 그걸 모두 삭제 + 카운트
(4) 큐에서 pop한 값보다 큰 값이 있으면 (3)의 과정을 멈추고 index를 올리고 다시 (3)의 과정을 반복
(5) index 의 pop하면서 카운트된 값들을 저장한 뒤 해당 배열을 return
*/

function solution(progresses, speeds){
    var answer = [];
    let remainder , a, b;
    var list = [];

    for(let i=0; i<progresses.length; i++){
        remainder = 100 - progresses[i];

        a = parseInt(remainder / speeds[i]);
        b = remainder % speeds[i];
        if(b == 0){
            console.log(`a : ${a}, b : ${b}, idx : ${i}`);
            list.push(a);
        }
        else {
            console.log(`a : ${a}, b : ${b}, idx : ${i}`);
            list.push(a+1);
        }
    } 

    list.forEach((v, idx, arr) => {
        console.log(`v: ${v}, idx : ${idx}, arr : ${arr}`);
    })
    return answer;
}

console.log(solution([93,30,55], [1,30,5]));