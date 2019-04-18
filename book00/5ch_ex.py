# page 142 연습 프로젝트
def displayInventory(inventory):
    print("Inventory:")
    item_total = 0
    for k, v in inventory.items():
        print(str(v) + ' ' + k)
        item_total += v
    print("Total number of items:" + str(item_total))

def addToInventory(inv, loot):
    for item in loot:
        if item in inv.keys():
            inv[item] += 1
        else:
            inv.setdefault(item, 1)
    return inv


inv = {'gold coin': 42, 'rope': 1}
dragonLoot = ['gold coin', 'dagger', 'gold coin', 'ruby']
inv = addToInventory(inv, dragonLoot)
displayInventory(inv)