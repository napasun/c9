test('null', () => {
    const n = null;
    expect(n).toBeNull(); //null 에만 매칭
    expect(n).toBeDefined(); //정의하지 않은 항목
    expect(n).not.toBeUndefined(); //위에 반대
    expect(n).not.toBeTruthy(); //if문이 true처리하는 것과 일치
    expect(n).toBeFalsy(); //if 문이 fasle로 처리하는 것과 일치
});

test('zero', () => {
    const n = 0;
    //expect(n).toBeNull(); //null 에만 매칭 에러
    expect(n).toBeDefined(); //정의하지 않은 항목
    expect(n).not.toBeUndefined(); //위에 반대
    expect(n).not.toBeTruthy(); //if문이 true처리하는 것과 일치
    expect(n).toBeFalsy(); //if 문이 fasle로 처리하는 것과 일치
});