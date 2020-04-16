'use strict';
module.exports = {
  up: (queryInterface, Sequelize) => {  // 마이그레이션을 실행할 때 수행하는 작업
    return queryInterface.createTable('Posts', {
      id: {
        allowNull: false,
        autoIncrement: true,
        primaryKey: true,
        type: Sequelize.INTEGER
      },
      text: {
        type: Sequelize.TEXT
      },
      createdAt: {
        allowNull: false,
        type: Sequelize.DATE
      },
      updatedAt: {
        allowNull: false,
        type: Sequelize.DATE
      }
    });
  },
  down: (queryInterface, Sequelize) => {    //마이그레이션을 취소할 때
    return queryInterface.dropTable('Posts');
  }
};