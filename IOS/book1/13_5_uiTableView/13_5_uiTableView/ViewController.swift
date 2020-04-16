//
//  ViewController.swift
//  13_5_uiTableView
//
//  Created by estgames on 2017. 12. 11..
//  Copyright © 2017년 estgames. All rights reserved.
//

import UIKit

let sectionTitle = ["나비목", "메뚜기목", "갑충목"]
let section0 = [("네발나비","네발나비과"),("남방제비나비","호랑나비과")]
let section1 = [("여치","여치과"),("변색애기메뚜기","메뚜기과"),("귀뚜라미","귀뚜라미과")]
let section2 = [("길앞잡이","길앞잡이과"),("딱정벌레","딱정벌레과"),("꼬마사슴벌레","사슴벌레과")]
let tableData = [section0, section1, section2]
                                        //테이블을 조작하기 위한 이벤트 처리, 데이터 설정
class ViewController: UIViewController, UITableViewDelegate, UITableViewDataSource {
    //섹션 수를 정한다.
    func numberOfSections(in tableView: UITableView) -> Int {
        return sectionTitle.count
    }
    //섹션마다 행 수를 반환한다.
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        let sectionData = tableData[section]
        return sectionData.count
    }
    //섹션 타이틀을 반환한다.
    public func tableView(_ tableView: UITableView, titleForHeaderInSection section: Int) -> String? {
        return sectionTitle[section]
    }
    //셀을 만든다. 셀 반환
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = UITableViewCell(style: .subtitle, reuseIdentifier: "cell")
        let sectionData = tableData[(indexPath as NSIndexPath).section]//선택된 섹션번호
        let cellData = sectionData[(indexPath as NSIndexPath).row]//선택된 행 번호
        cell.textLabel?.text = cellData.0
        cell.detailTextLabel?.text = cellData.1
        return cell
    }
    // 행이 탭되면 실행된다
    func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {
        let title = sectionTitle[indexPath.section]
        let sectionData = tableData[indexPath.section]
        let cellData = sectionData[indexPath.row]
        print("\(title)\(cellData.1)")
        print("\(cellData.0)")
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
        //델리게이트, 데이터 소스 설정
        let myTableView = UITableView(frame: view.frame, style: .grouped)
        myTableView.delegate = self
        myTableView.dataSource = self
        view.addSubview(myTableView)
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }


}

