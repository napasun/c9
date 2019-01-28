const shoppingList = [
    'diapers',
    'kleenex',
    'beer',
    'paper towels'
]

test ('the shopping  list has beer on it', () => {
    expect(shoppingList).toContain('beer')
})