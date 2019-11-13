'use strict';

module.exports = {
  up: (queryInterface, Sequelize) => {
    // 유저 테이블이 있을 경우 실행
    return queryInterface.sequelize.query(
      'SELECT id from graphbook_dev.Users;',
    ).then((users) => {
      const usersRows = users[0];

      return queryInterface.bulkInsert('Posts', [{
        text: 'Lorem ipsum 1',
        userId: usersRows[0].id,
        createdAt: new Date(),
        updatedAt: new Date(),
      },
      {
        text: 'Lorem ipsum 2',
        userId: usersRows[1].id,
        createdAt: new Date(),
        updatedAt: new Date(),
      }],
      {});
   });
 },
  down: (queryInterface, Sequelize) => {
    return queryInterface.bulkDelete('Posts', null, {});
  }
};
