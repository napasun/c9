npm install-g sequelize-cli

마이그레이션 파일 생성
sequelize model:generate --models-path src/server/models --migrations-path src/server/migrations --name Post --attributes text:text
sequelize model:generate --models-path src/server/models --migrations-path src/server/migrations --name User --attributes avatar:string,username:string

마이그레이션 파일 적용
sequelize db:migrate --migrations-path src/server/migrations --config src/server/config/index.js

마이그레이션 실행 취소
sequelize db:migrate:undo --migrations-path src/server/migrations --config src/server/config/index.js

특정 마이그레이션으로 돌아가기
sequelize db:migrate:undo:all --to XXXXXXXXXXXXXX-create-posts.js --migrations-path src/server/migrations --config src/server/config/index.j

마이그레이션 파일 만들기
sequelize migration:create --migrations-path src/server/migrations --name add-userId-to-post

시드파일 생성
sequelize seed:generate --name fake-posts --seeders-path src/server/seeders
sequelize seed:generate --name fake-users --seeders-path src/server/seeders

시드파일 적용
sequelize db:seed:all --seeders-path src/server/seeders --config src/server/config/index.js