test('there is no I in them', () => {
    expect('team').not.toMatch(/I/);
})

test('but there is a "shop" in christoph', () =>{
    expect('Christoph').toMatch(/stop/)
})