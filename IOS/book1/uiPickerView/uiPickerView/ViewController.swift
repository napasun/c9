//
//  ViewController.swift
//  uiPickerView
//
//  Created by estgames on 2017. 12. 11..
//  Copyright © 2017년 estgames. All rights reserved.
//

import UIKit
                                        //피커 뷰를 사용하려면 2개의 프로토콜을 사용해야 한다.
class ViewController: UIViewController, UIPickerViewDelegate, UIPickerViewDataSource {

    @IBOutlet weak var myPickerView: UIPickerView!
    let compos = [["월","화","수","목","금"], ["새벽","오전 중","오후","야간"]]
    
    func numberOfComponents(in pickerView: UIPickerView) -> Int {
        return compos.count //컴포넌트 갯수 반환
    }
    
    func pickerView(_ pickerView: UIPickerView, numberOfRowsInComponent component: Int) -> Int {
        let compo = compos[component]
        return compo.count  //컴포넌트 항목 갯수 반환
    }
    
    func pickerView(_ pickerView: UIPickerView, widthForComponent component: Int) -> CGFloat {
        if component == 0 { //컴포넌트 너비 지정
            return 50
        } else {
            return 100
        }
    }
    
    func pickerView(_ pickerView: UIPickerView, didSelectRow row: Int, inComponent component: Int) {
        //항목이 선택 되었을 때 호출되는 메서드
        let item = compos[component][row]
        print("\(item)가/이 선택되었습니다.")
        
        let row1 = pickerView.selectedRow(inComponent: 0)
        let row2 = pickerView.selectedRow(inComponent: 1)
        print("현재 선택된 행 번호 \(row1, row2)")
        
        let item1 = self.pickerView(pickerView, titleForRow: row1, forComponent: 0)
        let item2 = self.pickerView(pickerView, titleForRow: row2, forComponent: 1)
        print("현재 선택된 항목명 \(item1, item2)")
    }
    
    func pickerView(_ pickerView: UIPickerView, titleForRow row: Int, forComponent component: Int) -> String? {
        let item = compos[component][row]
        return item //차례대로 꺼내서 피커뷰에 설정한다.
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
        //델리게이트, 데이터소스 설정
        myPickerView.delegate = self
        myPickerView.dataSource = self
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }


}

