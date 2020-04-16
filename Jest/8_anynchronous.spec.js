function fetchData(ddd) {
    ddd('peanut butter')
    return "peanut butter"
}


//비동기 패턴 첫번째 콜밸
test('the data is peanut butter', done => {
    function callback(data) {
        expect(data).toBe('peanut butter');
        done();
    }

    fetchData(callback);
});

//promises

// test('the data is peanut butter', () => {
//     return fetchData().then(data => {
//         expect(data).toBe('peanut butter');
//     });
// })

// test('test fetch fails with an error', () => {
//     expect.assertions(1);
//     return fetchData().catch(e => expect(e).toMatch('error'));
// })

// test('the data is peanut butter', () => {
//     return expect(fetchData()).resolves.toBe("peanut butter")
// });

// test('the data is peanut butter', async () => {
//     expect.assertions(1);
//     const data = await fetchData();
//     expect(data).toBe('peanut butter')
// })
